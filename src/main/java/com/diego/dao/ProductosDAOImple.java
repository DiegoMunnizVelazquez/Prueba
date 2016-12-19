package com.diego.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diego.dao.ProductosDAO;
import com.diego.modelo.Producto;

@Repository
public class ProductosDAOImple implements ProductosDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductosDAOImple() {
		
	}
	
	public ProductosDAOImple(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Producto> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Producto> listProducto = (List<Producto>) sessionFactory.getCurrentSession()
				.createCriteria(Producto.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listProducto;
	}
	@Transactional
	public Producto get(int id) {
		String hql = "from Producto where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Producto> listUser = (List<Producto>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	
	}

	@Transactional
	public void saveOrUpdate(Producto producto) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(producto);
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Producto productoToDelete = new Producto();
		productoToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(productoToDelete);

	}

}
