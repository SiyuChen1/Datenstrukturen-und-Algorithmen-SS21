package de.unistuttgart.vis.dsass2021.ex07.p3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeMap;

import de.unistuttgart.vis.dsass2021.ex07.p3.MetaData.JunctionDetails;
import de.unistuttgart.vis.dsass2021.ex07.p3.MetaData.StreetDetails;

public class GraphLoader {

	public static StreetGraph loadStreetGraph(URL nodes, URL edges) throws IOException
	{
		try(
				InputStream nfis = nodes.openStream();
				BufferedInputStream nbis = new BufferedInputStream(nfis);
				Scanner nsc = new Scanner(nbis, StandardCharsets.UTF_8.name());
				
				InputStream efis = edges.openStream();
				BufferedInputStream ebis = new BufferedInputStream(efis);
				Scanner esc = new Scanner(ebis, StandardCharsets.UTF_8.name());
		){
			StreetGraph g = new StreetGraph();
			
			int idx=0;
			TreeMap<Long, Integer> id2idx = new TreeMap<>();
			// load nodes
			String line = nsc.nextLine();
			while(nsc.hasNextLine()){
				line = nsc.nextLine().trim();
				if(line.isEmpty())
					continue;
				// fields are osmid;x;y;highway
				String[] fields = line.split(";",-1);
				long osmID = Long.parseLong(fields[0]);
				float x = Float.parseFloat(fields[1]);
				float y = Float.parseFloat(fields[2]);
				String highway = fields[3];
				id2idx.put(osmID, idx++);
				g.addNode(new JunctionDetails(osmID, x, y, highway));
			}
			
			line = esc.nextLine();
			while(esc.hasNextLine()){
				line = esc.nextLine().trim();
				if(line.isEmpty())
					continue;
				// fields are src;dst;oneway;highway;name;length;maxspeed
				String[] fields = line.split(";",-1);
				long src_ = Long.parseLong(fields[0]);
				long dst_ = Long.parseLong(fields[1]);
				boolean oneway = Boolean.parseBoolean(fields[2]);
				String highway = fields[3];
				String name = fields[4];
				float length = Float.parseFloat(fields[5]);
				int maxspeed = Integer.parseInt(fields[6].substring(0, fields[6].indexOf(' ')));
				
				// edge data
				StreetDetails meta = new StreetDetails(oneway, highway, name, length, maxspeed);
				int src = id2idx.getOrDefault(src_,-1);
				int dst = id2idx.getOrDefault(dst_,-1);
				// discard edge if it points to non existing node
				if(src<0 || dst<0){
					continue;
				}
				g.addEdge(src, dst, meta);
			}
			return g;
		}
	}
	
	public static StreetGraph loadBirminghamStreetGraph(){
		try {
			return loadStreetGraph(
					GraphLoader.class.getResource("/birmingham_node_list_cleaned.csv"), 
					GraphLoader.class.getResource("/birmingham_edge_list_cleaned.csv")
					);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the street graph, something is fishy.", e);
		}
	}
	
	public static WeightedGraph<String, String> loadExampleGraph(){
		WeightedGraph<String, String> g = new WeightedGraph<>();
		g.addNode("A");// 0
		g.addNode("B");// 1
		g.addNode("C");// 2
		g.addNode("D");// 3
		g.addNode("E");// 4
		g.addNode("F");// 5
		g.addNode("G");// 6
		g.addNode("H");// 7
		g.addEdge(0, 3, 1.0).setMetaData("AD");
		
		g.addEdge(1, 3, 1.0).setMetaData("BD");
		g.addEdge(1, 5, 1.0).setMetaData("BF");
		
		g.addEdge(2, 5, 1.0).setMetaData("CF");
		g.addEdge(2, 6, 1.0).setMetaData("CG");
		
		g.addEdge(3, 1, 1.0).setMetaData("DB");
		g.addEdge(3, 5, 1.0).setMetaData("DF");
		g.addEdge(3, 7, 1.0).setMetaData("DH");
		
		g.addEdge(4, 6, 1.0).setMetaData("EG");
		g.addEdge(4, 7, 1.0).setMetaData("EH");
		
		g.addEdge(5, 1, 1.0).setMetaData("FB");
		
		g.addEdge(6, 7, 1.0).setMetaData("GH");
		
		
		return g;
	}

}
