package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport,DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private Map<Integer, Airport> idMap;
	
	public Model() {
				
	}
	
	public void creaGrafo(int distanzaMinima) {
		this.dao = new ExtFlightDelaysDAO();
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.idMap=dao.loadAllAirports();
		Graphs.addAllVertices(this.grafo,idMap.values());
		
		for(CoppiaAeroporti c : dao.getCoppiaAeroporti(this.idMap,distanzaMinima)) {
			Graphs.addEdge(this.grafo,c.getA1(), c.getA2(), c.getDistanzaMedia());			
		}
		
		System.out.println(this.grafo.vertexSet().size()+" "+this.grafo.edgeSet().size());
		
		
	}
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	public void archiGrafo() {
	for(Rotta e : this.grafo.edgeSet()) {
		e.
		
	}
	}
	

}
