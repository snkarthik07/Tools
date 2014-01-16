package kasnplugin.views;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;

public class OpenKasnViewActionDelegate implements
		IWorkbenchWindowActionDelegate {
	
	private IWorkbenchWindow window;
	
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		this.window = window;
	}

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		
		if (window == null)
			return;
		
		IWorkbenchPage page = window.getActivePage();
		if(page == null)
			return;
		
		try{
			page.showView(SampleView.ID);
		}
		catch(PartInitException e){
//			FavoritesLog.logError("Failed to open the Favourites View",e);
		}

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
