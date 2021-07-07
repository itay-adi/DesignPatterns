/********************
 * Developer: Itay Adi Yosef
 * Date: November 16th
 * Reviewer: Atar Yehie
 */

package il.co.ilrd.composite;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

//composite tree
public class Tree {
	private FileComponent component;

	// constructor 
	public Tree(String path) {
        File root = new File(path);
        
        if (root.exists()) {
            if (root.isDirectory()){
                component = new FolderComposite(root);
            } else {
                component = new FileLeaf(root);
            }
        } else {
        	System.out.println("Path does not exist.");
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
				if(temp.isDirectory()) {
					componentList.add(new FolderComposite(temp));
				}

				else {
					componentList.add(new FileLeaf(temp));	
				}
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
