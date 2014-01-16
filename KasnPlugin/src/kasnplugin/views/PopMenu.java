package kasnplugin.views;

import kasnplugin.Activator;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;


public class PopMenu {
	
	public static void createPopUp(Table top){
		
		final Table table = top;
		Menu menu = new Menu(top);
		final OpenExplorer openExplorer = new OpenExplorer();
	
		MenuItem openItem = new MenuItem (menu, SWT.NONE);
		openItem.setText("Open Contataining Folder");
		openItem.setImage(Activator.getImage("Open"));
		openItem.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem selected[] = table.getSelection();
				openExplorer.openExp(selected[0].getText(2));
			}
			
			
		});
	
		top.setMenu(menu);
		
		
	}

}
