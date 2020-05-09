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
		
		for(CoppiaAeroporti c : dao.getCoppiaAeroporti(idMap, distanzaMinima)) {
			DefaultWeightedEdge e = this.grafo.getEdge(c.getA1(), c.getA2());
			if(e == null) {
				Graphs.addEdgeWithVertices(this.grafo, c.getA1(), c.getA2(), c.getDistanzaMedia());
				}
			else {
				double mediaVecchia = this.grafo.getEdgeWeight(e);
				double mediaNuova = (mediaVecchia+c.getDistanzaMedia())/2;
				this.grafo.setEdgeWeight(e, mediaNuova);
			}
		}
		
		System.out.println(this.grafo.vertexSet().size()+" "+this.grafo.edgeSet().size());
		
		
	}
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	public String archiGrafo() {
		String s = "";
		for(DefaultWeightedEdge e : grafo.edgeSet()) {
			String riga = "Partenza: "+grafo.getEdgeSource(e).getCity()+" Arrivo: "+grafo.getEdgeTarget(e).getCity()+" Distanza media: "+grafo.getEdgeWeight(e);
			s+=riga+"\n";
		}
	
		return s;
	}
	

}
