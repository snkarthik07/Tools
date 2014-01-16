package plugin;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class ClassNameTableLabelProvider extends LabelProvider implements
		ITableLabelProvider {
	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getColumnText(Object element, int index) {
		ClassName className = (ClassName) element;
		switch(index){
		case 0:
			return className.classFile;
		case 1:
			return className.zipFile;
		case 2:
			return className.path;
		default:
			return "unknown" + index;
	
		}
	}	
}
