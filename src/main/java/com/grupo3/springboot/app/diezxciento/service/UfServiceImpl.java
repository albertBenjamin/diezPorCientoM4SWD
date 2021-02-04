package com.grupo3.springboot.app.diezxciento.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.springboot.app.diezxciento.dao.IUfDao;
import com.grupo3.springboot.app.diezxciento.entity.Uf;
import com.grupo3.springboot.app.diezxciento.models.Dxc;
import com.grupo3.springboot.app.diezxciento.utils.Util;

@Service
public class UfServiceImpl implements IUfService {

	private final static String IND_UF = "uf";

	@Autowired
	IUfDao ufDao;

	@Override
	public List<Uf> findAll() {
		return (List<Uf>) ufDao.findAll();
	}

	@Override
	public Uf save(Uf uf) {
		return ufDao.save(uf);
	}

	@Override
	public Dxc obtenerDiezxCiento(Integer iAhorro, Integer iSueldo) {
		Uf uf = validaUf();
		Dxc dxc = new Dxc(iAhorro, iSueldo);
		dxc.setDxc(Util.getDxc(dxc.getAhorro(),uf.getValor()));
		dxc.setImpuesto(Util.getImpuesto(dxc.getSueldo(), dxc.getDxc()));
		return dxc;
	}

	@Override
	public Uf validaUf() {
		Uf uf = new Uf();
		if (findAll().isEmpty()) {
			uf.setFecha(new Date());
			uf.setValor((int) Util.getIndicadorDiario(IND_UF).getSerie().get(0).getValor());
			save(uf);
		} else {
			uf = findAll().get(0);
		}
		return uf;
	}

}
