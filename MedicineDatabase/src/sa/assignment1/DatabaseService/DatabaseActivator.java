package sa.assignment1.DatabaseService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DatabaseActivator implements BundleActivator {

	ServiceRegistration<?> publishServiceRegistration;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) {
		System.out.println("Database Publisher Started !!!");
		MedicineDao medicineDao = new MedicineDaoImpl();
		publishServiceRegistration = context.registerService(MedicineDao.class.getName(), medicineDao, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) {
		System.out.println("Database Publisher Stoped !!!");
		publishServiceRegistration.unregister();
	}

}