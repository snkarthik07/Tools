package kasnplugin.views;


import java.util.ArrayList;
import java.util.Iterator;

import kasnplugin.Activator;
import kasnplugin.utitlity.SampleJob;

import org.eclipse.swt.widgets.*;
import org.eclipse.ui.part.*;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.*;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;

import plugin.ClassFind;
import plugin.ClassName;
import plugin.ClassNameTableLabelProvider;


public class SampleView extends ViewPart {
	
	private Label l1 = null;
	private Text classText = null;
	private Label l2 = null;
	private Text textLocation = null;
	private Button cancel = null;
	private Table resultTable = null;
	private Button search = null;
	private Button browse = null;
		
	public static final String ID = "kasnplugin.views.SampleView";
	
	SampleView sv;
	
	public SampleView() {
		sv = this;
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		
//		final MessageBox messageBox = new MessageBox(parent, SWT.OK | SWT.ICON_ERROR);
		ProgressMonitorDialog pd;
		final OpenExplorer openExplorer = new OpenExplorer();
		
		final ClassFind classFind = new ClassFind();
		GridData gridData31 = new GridData();
		gridData31.horizontalSpan = 2;
		gridData31.verticalAlignment = GridData.CENTER;
		gridData31.grabExcessHorizontalSpace = false;
		gridData31.horizontalAlignment = GridData.FILL;
		GridData gridData11 = new GridData();
		gridData11.horizontalSpan = 2;
		gridData11.horizontalAlignment = GridData.FILL;
		gridData11.verticalAlignment = GridData.CENTER;
		gridData11.grabExcessHorizontalSpace = false;
		GridData gridData5 = new GridData();
		gridData5.horizontalAlignment = GridData.FILL;
		gridData5.verticalAlignment = GridData.CENTER;
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.horizontalIndent = 2;
		gridData3.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = false;
		gridData1.horizontalIndent = 2;
		gridData1.verticalAlignment = GridData.CENTER;
		GridData gridData = new GridData();
		gridData.horizontalSpan = 6;
		gridData.horizontalAlignment = GridData.BEGINNING;
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalIndent = 3;
		gridData.grabExcessVerticalSpace = true;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalSpan = 6;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 8;
		gridLayout.makeColumnsEqualWidth = true;
		
		l1 = new Label(parent, SWT.NONE);
		l1.setText("Class Name");
		
		classText = new Text(parent, SWT.BORDER);
		classText.setLayoutData(gridData11);
		Label filler4 = new Label(parent, SWT.NONE);
		Label filler5 = new Label(parent, SWT.NONE);
		Label filler8 = new Label(parent, SWT.NONE);
		Label filler11 = new Label(parent, SWT.NONE);
		Label filler16 = new Label(parent, SWT.NONE);
		l2 = new Label(parent, SWT.NONE);
		l2.setText("Directory");
		
		textLocation = new Text(parent, SWT.BORDER);
		textLocation.setLayoutData(gridData31);
		browse = new Button(parent, SWT.NONE);
		browse.setText("Browse");
		browse.setLayoutData(gridData5);
		Label filler3 = new Label(parent, SWT.NONE);
		Label filler7 = new Label(parent, SWT.NONE);
		Label filler10 = new Label(parent, SWT.NONE);
		Label filler13 = new Label(parent, SWT.NONE);
		search = new Button(parent, SWT.NONE);
		search.setText("Search");
		search.setLayoutData(gridData3);
		cancel = new Button(parent, SWT.NONE);
		cancel.setText("Cancel");
		cancel.setLayoutData(gridData1);
		Label filler = new Label(parent, SWT.NONE);
		Label filler1 = new Label(parent, SWT.NONE);
		Label filler2 = new Label(parent, SWT.NONE);
		Label filler6 = new Label(parent, SWT.NONE);
		Label filler9 = new Label(parent, SWT.NONE);
		Label filler12 = new Label(parent, SWT.NONE);
		final TableViewer tableViewer  = new TableViewer(parent, SWT.SINGLE | SWT.FULL_SELECTION);
		resultTable = tableViewer.getTable();
		resultTable.setLinesVisible(true);
		resultTable.setLayoutData(gridData);
		resultTable.setHeaderVisible(true);
//		resultTable.setBounds(100,100,200,200);
		TableColumn tableColumn = new TableColumn(resultTable, SWT.NONE);
		tableColumn.setWidth(160);
		tableColumn.setText("Class Name");
		TableColumn tableColumn1 = new TableColumn(resultTable, SWT.NONE);
		tableColumn1.setWidth(160);
		tableColumn1.setText("File Name");
		TableColumn tableColumn2 = new TableColumn(resultTable, SWT.NONE);
		tableColumn2.setWidth(160);
		tableColumn2.setText("Path");
		resultTable.pack();
		tableViewer.setLabelProvider(new ClassNameTableLabelProvider());
		tableViewer.setContentProvider(new ArrayContentProvider());
		parent.setLayout(gridLayout);
		parent.setSize(new Point(500, 400));
		
		
		
		search.addSelectionListener(new SelectionAdapter(){
			
			@Override			
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				if(classText.getText().isEmpty()|textLocation.getText().isEmpty()){
//					messageBox.setText("Warning");
//					messageBox.setMessage("Enter ClassName and Select Directory");
//					messageBox.open();					
				}else{	
					String className = classText.getText();
					String dir = textLocation.getText();
					tableViewer.refresh();
					classFind.setClassName(className);
					classFind.setDir(dir);
					SampleJob job = new SampleJob("s");
					job.setViewer(tableViewer);
					job.setClassFind(classFind);
					job.schedule();
//					job.cancel();
				}
			}		
				
		});
		
		browse.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell =PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				DirectoryDialog dialog =  new DirectoryDialog(shell, SWT.NULL);
				String path = dialog.open();
				if(path!=null){
					textLocation.setText("");
				textLocation.setText(path);
				}
			}
		});
		
		cancel.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				//dispose();
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(sv);
			}
			
		});
		
		resultTable.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				TableItem[] selected = resultTable.getSelection();
				Runtime runtime = Runtime.getRuntime();
				if(selected.length > 0){
					openExplorer.openExp(selected[0].getText(2));
				}				
			}		
			
		});
		
		PopMenu.createPopUp(resultTable);
		
	}
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		
	}
}