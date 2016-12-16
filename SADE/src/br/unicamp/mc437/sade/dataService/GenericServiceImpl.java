package br.unicamp.mc437.sade.dataService;

import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;

import br.unicamp.mc437.sade.DAO.GenericDAO;
import br.unicamp.mc437.sade.DAO.GenericDAOImpl;
import br.unicamp.mc437.sade.persistance.Desenvolvedor;

public class GenericServiceImpl<T> implements GenericService<T> {
	private GenericDAO<T> dao;
	private Class<T> cl;

	public GenericServiceImpl(Class<T> cl, SessionFactory sessionFactory) {
		this.cl = cl;
		dao = new GenericDAOImpl<T>(cl, sessionFactory);
	}

	@Override
	public T get(Class<T> cl, Integer id) {
		return (T) dao.get(cl, id);
	}

	@Override
	public T save(T object) {
		return (T) dao.save(object);
	}

	@Override
	public void update(T object) {
		dao.update(object);
	}

	@Override
	public void delete(T object) {
		dao.delete(object);
	}

	@Override
	public List<T> query(String hsql, Map<String, Object> params) {
		return (List<T>) dao.query(hsql, params);
	}

	@Override
	public List<T> getAll() {
		return query("from " + cl.getName(), null);
	}

	@Override
	public void deleteAll() {
		List<T> devs = getAll();
		for (T dev: devs)
			delete(dev);

	}
}
