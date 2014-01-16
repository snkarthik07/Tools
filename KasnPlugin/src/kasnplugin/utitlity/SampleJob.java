package kasnplugin.utitlity;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;

import plugin.ClassFind;
import plugin.ClassName;

public class SampleJob extends Job {

	private TableViewer viewer;
	private ClassFind classFind;
	
	public void setClassFind(ClassFind find){
		classFind = find;
	}
	
	public SampleJob(String arg0){
		super(arg0);
	}
	
	public void setViewer(TableViewer tviewer){
		viewer = tviewer;
	}
	
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		
		classFind.setViewer(viewer);
		classFind.visitDir();
		return Status.OK_STATUS;
	}
}
