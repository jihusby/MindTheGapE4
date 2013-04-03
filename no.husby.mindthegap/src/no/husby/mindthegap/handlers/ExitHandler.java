package no.husby.mindthegap.handlers;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class ExitHandler {
	Logger logger = Logger.getLogger(Class.class);

	@Execute
	public void execute(IWorkbench workbench) {
		workbench.close();
	}

	@CanExecute
	public boolean canExecute() {
		return true;

	}
}
