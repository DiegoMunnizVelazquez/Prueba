package com.diego.dao;

import java.util.List;

import com.diego.modelo.Producto;

public interface ProductosDAO {
	public List<Producto> list();
	
	public Producto get(int id);
	
	public void saveOrUpdate(Producto producto);
	
	public void delete(int id);
}
