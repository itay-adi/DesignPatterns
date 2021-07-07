package il.co.ilrd.factory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FactoryTree {
	private FileComponent component;
	Factory<Boolean, FileComponent ,File> myFactory = new Factory<>();

	// constructor 
	public FactoryTree(String path) {
        File root = new File(path);
        myFactory.add(true, FolderComposite::new);
        myFactory.add(false, FileLeaf::new);
        
        if (root.exists()) {
        	component = myFactory.create(root.isDirectory(), root);
        }
    }
	
	public void printTree() {
		component.print(0);
	}

	private interface FileComponent {
		public void print(int indent);
	}

	private class FolderComposite implements FileComponent{
		private List<FileComponent> componentList;
		private final String name;

		// constructor - initiate componentList 
		private FolderComposite(File file) {
			name = file.getName();
			componentList = new ArrayList<>();

			for(File temp : file.listFiles()) {
				componentList.add(myFactory.create(temp.isDirectory(), temp));
			}
		}

		@Override
		public void print(int indent) {
			for (int i = 0 ; i < indent ; ++i) {
				System.out.print("\u2502   ");
			}

			System.out.println("\u251c\u2500\u2500" + name);

			for (FileComponent component : componentList) {
				component.print(indent + 1);
			}
		}
	}

	private class FileLeaf implements FileComponent{
		private final String name;

		private FileLeaf(File file) {
			this.name = file.getName();
		}

		@Override
		public void print(int indent) {
			for (int i = 0 ; i < indent ; ++i) {
				System.out.print("\u2502   ");
			}
			System.out.println("\u2514\u2500\u2500" + name);
		}    
	}
}
