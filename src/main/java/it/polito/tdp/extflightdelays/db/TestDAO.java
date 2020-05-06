package it.polito.tdp.extflightdelays.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.extflightdelays.model.Airport;
import it.polito.tdp.extflightdelays.model.CoppiaAeroporti;

public class TestDAO {

	public static void main(String[] args) {

		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();

		Map<Integer, Airport> mappa = new HashMap<>();
		//System.out.println(dao.loadAllAirlines());
		//System.out.println(dao.loadAllAirports(mappa).values());
		//System.out.println(dao.loadAllFlights().size());
		//dao.loadAllAirports(mappa);
		System.out.println(dao.loadAllAirports().values());
		/*List<CoppiaAeroporti> c = dao.getCoppiaAeroporti(mappa, 500);
		for(CoppiaAeroporti cc : c) {
			System.out.println(cc);
		}*/
	}

}
