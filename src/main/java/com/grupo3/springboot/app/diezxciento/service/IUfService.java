package com.grupo3.springboot.app.diezxciento.service;

import java.util.List;

import com.grupo3.springboot.app.diezxciento.entity.Uf;
import com.grupo3.springboot.app.diezxciento.models.Dxc;

public interface IUfService {

	List<Uf> findAll();
	Uf save(Uf uf);
	Dxc obtenerDiezxCiento(Integer iAhorro, Integer iSueldo);
	Uf validaUf();
}
