package com.example.practica2;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practica2.cultivo.Cultivo;
import com.example.practica2.cultivo.RepositorioCultivos;
import com.example.practica2.especie.Especie;
import com.example.practica2.especie.RepositorioEspecies;
import com.example.practica2.plaga.Plaga;
import com.example.practica2.plaga.RepositorioPlagas;
import com.example.practica2.producto.Producto;
import com.example.practica2.producto.RepositorioProductos;
import com.example.practica2.sustancia.RepositorioSustancias;
import com.example.practica2.sustancia.Sustancia;

@Component
public class DatabaseInitializer {

	@Autowired
	private RepositorioCultivos repoCultivos;

	@Autowired
	private RepositorioEspecies repoEspecies;

	@Autowired
	private RepositorioPlagas repoPlagas;

	@Autowired
	private RepositorioSustancias repoSustancias;

	@Autowired
	private RepositorioProductos repoProductos;

	@PostConstruct
	public void init() {

		// 4 Categorias de Cultivos

		Cultivo c1 = new Cultivo("Hortalizas");
		Cultivo c2 = new Cultivo("Cereales");
		Cultivo c3 = new Cultivo("Frutas");
		Cultivo c4 = new Cultivo("Leguminosas");
		Cultivo c5 = new Cultivo("Verduras");

		repoCultivos.saveAndFlush(c1);
		repoCultivos.saveAndFlush(c2);
		repoCultivos.saveAndFlush(c3);
		repoCultivos.saveAndFlush(c4);
		repoCultivos.saveAndFlush(c5);

		// 8 Especies
		Especie e1 = new Especie("Lentejas", "Lens culinaris"); // Leguminosas y verduras
		Especie e2 = new Especie("Manzana", "Malus domestica"); // Frutas
		Especie e3 = new Especie("Acelgas", "Beta vulgaris var. cicla"); // Hortaliza y verduras
		Especie e4 = new Especie("Trigo", "Triticum"); // Cereales
		Especie e5 = new Especie("Arroz", "Oryza sativa"); // Cereales
		Especie e6 = new Especie("Platano", "Musa"); // Frutas
		Especie e7 = new Especie("Judías", "Phaseolus vulgaris"); // Leguminosas y verduras
		Especie e8 = new Especie("Cebolla", "Allium cepa"); // Hortaliza y verduras

		repoEspecies.saveAndFlush(e1);
		repoEspecies.saveAndFlush(e2);
		repoEspecies.saveAndFlush(e3);
		repoEspecies.saveAndFlush(e4);
		repoEspecies.saveAndFlush(e5);
		repoEspecies.saveAndFlush(e6);
		repoEspecies.saveAndFlush(e7);
		repoEspecies.saveAndFlush(e8);

		List<Especie> aux = new ArrayList<>();

		aux.add(e3);
		aux.add(e8);
		c1.setEspecie(aux);
		repoCultivos.saveAndFlush(c1);
		aux.clear();

		aux.add(e4);
		aux.add(e5);
		c2.setEspecie(aux);
		repoCultivos.saveAndFlush(c2);
		aux.clear();

		aux.add(e2);
		aux.add(e6);
		c3.setEspecie(aux);
		repoCultivos.saveAndFlush(c3);
		aux.clear();

		aux.add(e1);
		aux.add(e7);
		c4.setEspecie(aux);
		repoCultivos.saveAndFlush(c4);
		aux.clear();

		aux.add(e1);
		aux.add(e3);
		aux.add(e7);
		aux.add(e8);
		c5.setEspecie(aux);
		repoCultivos.saveAndFlush(c5);
		aux.clear();

		// 16 Plagas
		Plaga p1 = new Plaga("Pulgón", "Pulguintis", " https://es.wikipedia.org/wiki/Aphididae"); // e1, e2, e3
		Plaga p2 = new Plaga("Cochinilla", "Cochinistus", "https://es.wikipedia.org/wiki/Dactylopius_coccus"); // e1, e4
		Plaga p3 = new Plaga("Mosca blanca", "Avemus polen", "https://es.wikipedia.org/wiki/Aleyrodidae"); // e2, e3
		Plaga p4 = new Plaga("Mosquito verde", "Mapicao", "https://es.wikipedia.org/wiki/Cacyreus_marshalli"); // e2
		Plaga p5 = new Plaga("Babosas", "Saliva pegajosa", "https://es.wikipedia.org/wiki/Empoasca_vitis"); // e2
		Plaga p6 = new Plaga("Hormigas", "Hormigon", "https://es.wikipedia.org/wiki/Caracol"); // e3
		Plaga p7 = new Plaga("Avispa serradora", "Abejanus", "https://www.nationalgeographic.es/animales/hormiga"); // e3
		Plaga p8 = new Plaga("Procesionaria del pino", "Procesus abeto", "https://www.jardineriaon.com/abeja-cortadora-de-hojas.html"); // e4
		Plaga p9 = new Plaga("Trips", "Tripitrisquis", "http://www.redforesta.com/blog/2010/10/29/la-procesionaria-del-pino-ciclo-biologico-danos-y-metodos-de-control/"); // e4
		Plaga p10 = new Plaga("Minadores", "Bitcoiners", "http://www.juntadeandalucia.es/agriculturaypesca/visorraif/Ayudas/Algodon/TRIPS_DE.html"); // e5
		Plaga p11 = new Plaga("Araña roja", "Spider Manitis", "https://www.biobestgroup.com/es/biobest/plagas-y-enfermedades/minadores-de-hojas-5007/"); // e5
		Plaga p12 = new Plaga("Orugas", "Mariposis minus", "http://www.juntadeandalucia.es/agriculturaypesca/visorraif/Ayudas/Algodon/ARANA_DE.html"); // e6
		Plaga p13 = new Plaga("Caracoles", "Fernandus Alonsus", "http://www.juntadeandalucia.es/agriculturaypesca/visorraif/Ayudas/Algodon/ARANA_DE.html"); // e6
		Plaga p14 = new Plaga("Gusanos de suelo", "Delianos Ionutis", "https://es.wikipedia.org/wiki/Oruga_(larva)"); // e7
		Plaga p15 = new Plaga("Hongos", "Ivanus Pelis Setus", "https://es.wikipedia.org/wiki/Babosa"); // e7
		Plaga p16 = new Plaga("Mariposa del geranio", "Ivanmus Mariposus", "https://www.sembrar100.com/plagas-y-enfermedades/gusano-blanco-del-suelo/"); // e8

		repoPlagas.saveAndFlush(p1);
		repoPlagas.saveAndFlush(p2);
		repoPlagas.saveAndFlush(p3);
		repoPlagas.saveAndFlush(p4);
		repoPlagas.saveAndFlush(p5);
		repoPlagas.saveAndFlush(p6);
		repoPlagas.saveAndFlush(p7);
		repoPlagas.saveAndFlush(p8);
		repoPlagas.saveAndFlush(p9);
		repoPlagas.saveAndFlush(p10);
		repoPlagas.saveAndFlush(p11);
		repoPlagas.saveAndFlush(p12);
		repoPlagas.saveAndFlush(p13);
		repoPlagas.saveAndFlush(p14);
		repoPlagas.saveAndFlush(p15);
		repoPlagas.saveAndFlush(p16);

		List<Plaga> aux2 = new ArrayList<>();

		aux2.add(p1);
		aux2.add(p2);
		e1.setPlagas(aux2);
		repoEspecies.saveAndFlush(e1);
		aux2.clear();

		aux2.add(p1);
		aux2.add(p3);
		aux2.add(p4);
		aux2.add(p5);
		e2.setPlagas(aux2);
		repoEspecies.saveAndFlush(e2);
		aux2.clear();

		aux2.add(p1);
		aux2.add(p3);
		aux2.add(p6);
		aux2.add(p7);
		e3.setPlagas(aux2);
		repoEspecies.saveAndFlush(e3);
		aux2.clear();

		aux2.add(p8);
		aux2.add(p9);
		e4.setPlagas(aux2);
		repoEspecies.saveAndFlush(e4);
		aux2.clear();

		aux2.add(p10);
		aux2.add(p11);
		e5.setPlagas(aux2);
		repoEspecies.saveAndFlush(e5);
		aux2.clear();

		aux2.add(p12);
		aux2.add(p13);
		e6.setPlagas(aux2);
		repoEspecies.saveAndFlush(e6);
		aux2.clear();

		aux2.add(p14);
		aux2.add(p15);
		e7.setPlagas(aux2);
		repoEspecies.saveAndFlush(e7);
		aux2.clear();

		aux2.add(p16);
		e8.setPlagas(aux2);
		repoEspecies.saveAndFlush(e8);
		aux2.clear();

		// 20 Sustancias
		Sustancia s1 = new Sustancia("Decanol"); // p1, p2, p3
		Sustancia s2 = new Sustancia("metilciclopropeno"); // p4, p5, p6
		Sustancia s3 = new Sustancia("naftilacetamida"); // p7, p8
		Sustancia s4 = new Sustancia("dimetilnaftaleno"); // p9, p10
		Sustancia s5 = new Sustancia("hidroxiquinoleina"); // p11, p12
		Sustancia s6 = new Sustancia("epibrasilónida"); // p13, p14
		Sustancia s7 = new Sustancia("Aceites de pescado"); // p15
		Sustancia s8 = new Sustancia("Aceite de parafina"); // p16
		Sustancia s9 = new Sustancia("Acequinocilo"); // p1
		Sustancia s10 = new Sustancia("Ácido acético"); // p2
		Sustancia s11 = new Sustancia("Acetato amónico"); // p3
		Sustancia s12 = new Sustancia("Ácido benzoico"); // p4
		Sustancia s13 = new Sustancia("Ácido giberélico"); // p5
		Sustancia s14 = new Sustancia("Ácidos grasos"); // p6
		Sustancia s15 = new Sustancia("Aclonifen"); // p7
		Sustancia s16 = new Sustancia("Acrinatrin"); // p8
		Sustancia s17 = new Sustancia("Arena de cuarzo"); // p9
		Sustancia s18 = new Sustancia("Benalaxil"); // p10
		Sustancia s19 = new Sustancia("Bentazona"); // p11
		Sustancia s20 = new Sustancia("Bupirimato"); // p12

		repoSustancias.saveAndFlush(s1);
		repoSustancias.saveAndFlush(s2);
		repoSustancias.saveAndFlush(s3);
		repoSustancias.saveAndFlush(s4);
		repoSustancias.saveAndFlush(s5);
		repoSustancias.saveAndFlush(s6);
		repoSustancias.saveAndFlush(s7);
		repoSustancias.saveAndFlush(s8);
		repoSustancias.saveAndFlush(s9);
		repoSustancias.saveAndFlush(s10);
		repoSustancias.saveAndFlush(s11);
		repoSustancias.saveAndFlush(s12);
		repoSustancias.saveAndFlush(s13);
		repoSustancias.saveAndFlush(s14);
		repoSustancias.saveAndFlush(s15);
		repoSustancias.saveAndFlush(s16);
		repoSustancias.saveAndFlush(s17);
		repoSustancias.saveAndFlush(s18);
		repoSustancias.saveAndFlush(s19);
		repoSustancias.saveAndFlush(s20);

		List<Sustancia> aux3 = new ArrayList<>();

		aux3.add(s1);
		aux3.add(s9);
		p1.setSustancias(aux3);
		repoPlagas.saveAndFlush(p1);
		aux3.clear();

		aux3.add(s1);
		aux3.add(s10);
		p2.setSustancias(aux3);
		repoPlagas.saveAndFlush(p2);
		aux3.clear();

		aux3.add(s1);
		aux3.add(s11);
		p3.setSustancias(aux3);
		repoPlagas.saveAndFlush(p3);
		aux3.clear();

		aux3.add(s2);
		aux3.add(s12);
		p4.setSustancias(aux3);
		repoPlagas.saveAndFlush(p4);
		aux3.clear();

		aux3.add(s2);
		aux3.add(s12);
		p5.setSustancias(aux3);
		repoPlagas.saveAndFlush(p5);
		aux3.clear();

		aux3.add(s2);
		aux3.add(s13);
		p6.setSustancias(aux3);
		repoPlagas.saveAndFlush(p6);
		aux3.clear();

		aux3.add(s3);
		aux3.add(s14);
		p7.setSustancias(aux3);
		repoPlagas.saveAndFlush(p7);
		aux3.clear();

		aux3.add(s3);
		aux3.add(s15);
		p8.setSustancias(aux3);
		repoPlagas.saveAndFlush(p8);
		aux3.clear();

		aux3.add(s4);
		aux3.add(s16);
		p9.setSustancias(aux3);
		repoPlagas.saveAndFlush(p9);
		aux3.clear();

		aux3.add(s4);
		aux3.add(s17);
		p10.setSustancias(aux3);
		repoPlagas.saveAndFlush(p10);
		aux3.clear();

		aux3.add(s5);
		aux3.add(s18);
		p11.setSustancias(aux3);
		repoPlagas.saveAndFlush(p11);
		aux3.clear();

		aux3.add(s5);
		aux3.add(s19);
		p12.setSustancias(aux3);
		repoPlagas.saveAndFlush(p12);
		aux3.clear();

		aux3.add(s6);
		aux3.add(s20);
		p13.setSustancias(aux3);
		repoPlagas.saveAndFlush(p13);
		aux3.clear();

		aux3.add(s6);
		p14.setSustancias(aux3);
		repoPlagas.saveAndFlush(p14);
		aux3.clear();

		aux3.add(s7);
		p15.setSustancias(aux3);
		repoPlagas.saveAndFlush(p15);
		aux3.clear();

		aux3.add(s8);
		p16.setSustancias(aux3);
		repoPlagas.saveAndFlush(p16);
		aux3.clear();

		// 30 productos
		Producto pf1 = new  Producto ("Azadiractina", "https://es.wikipedia.org/wiki/Azadiractina"); // s1, s2
		Producto pf2 = new  Producto ("Piretrinas", "https://es.wikipedia.org/wiki/Piretrina"); // s3, s4
		Producto pf3 = new  Producto ("Cuasia", "https://es.wikipedia.org/wiki/Quassia_amara"); // s5, s6
		Producto pf4 = new  Producto ("Aceites vegetales", "https://es.wikipedia.org/wiki/Aceite_vegetal"); // s7, s8
		Producto pf5 = new  Producto ("Proteínas hidrolizadas", "https://es.wikipedia.org/wiki/Prote%C3%ADna_hidrolizada"); // s9, s10
		Producto pf6 = new  Producto ("Lecitina", "https://es.wikipedia.org/wiki/Lecitina"); // s11
		Producto pf7 = new  Producto ("Cera de abejas", "https://es.wikipedia.org/wiki/%C3%81cido_mel%C3%ADsico"); // s12
		Producto pf8 = new  Producto ("Gelatina", "https://es.wikipedia.org/wiki/Gelatina"); // s13
		Producto pf9 = new  Producto ("Mircoorganismos", "https://es.wikipedia.org/wiki/Microorganismo"); // s14
		Producto pf10 = new Producto ("Spinosad", "https://en.wikipedia.org/wiki/Spinosad "); // s15
		Producto pf11 = new Producto ("Fofasto diamónico", "https://es.wikipedia.org/wiki/Fosfato_diam%C3%B3nico"); // s16
		Producto pf12 = new Producto ("Feromonas", "https://es.wikipedia.org/wiki/Feromona "); // s17
		Producto pf13 = new Producto ("Piretroides", "https://es.wikipedia.org/wiki/Piretroide"); // s18
		Producto pf14 = new Producto ("Fostafo Férrico", "https://it.wikipedia.org/wiki/Fosfato_ferrico"); // s19
		Producto pf15 = new Producto ("Cobre en forma de hidróxido de cobre", "https://es.wikipedia.org/wiki/Hidr%C3%B3xido_de_cobre_(II)"); // s20
		Producto pf16 = new Producto ("oxicloruro de cobre", "https://es.wikipedia.org/wiki/Oxicloruro_de_cobre"); // s1
		Producto pf17 = new Producto ("sulfato de cobre tribásico", "https://es.wikipedia.org/wiki/Sulfato_de_cobre"); // s2
		Producto pf18 = new Producto ("Etileno", "https://es.wikipedia.org/wiki/Etileno"); // s3
		Producto pf19 = new Producto ("Sal de potasio ricas en ácidos grasos", "https://es.wikipedia.org/wiki/Mineral_(nutriente)"); // s4
		Producto pf20 = new Producto ("Sulfato de aluminio y potasio", "https://es.wikipedia.org/wiki/Alumbre_de_potasio"); // s5
		Producto pf21 = new Producto ("Polisulfuro de calcio", "https://es.wikipedia.org/wiki/Polisulfuro_de_calcio"); // s6
		Producto pf22 = new Producto ("Aceite de parafina", "https://es.wikipedia.org/wiki/Parafina"); // s7
		Producto pf23 = new Producto ("Arena de cuarzo", "https://es.wikipedia.org/wiki/Arena"); // s8
		Producto pf24 = new Producto ("Azufre ", "https://es.wikipedia.org/wiki/Azufre"); // s9
		Producto pf25 = new Producto ("Hidróxido de calcio", "https://es.wikipedia.org/wiki/Hidr%C3%B3xido_de_calcio"); // s10
		Producto pf26 = new Producto ("Bicarbonato de potasio", "https://es.wikipedia.org/wiki/Carbonato_de_potasio"); // s11
		Producto pf27 = new Producto ("Laminarina", "https://gl.wikipedia.org/wiki/Laminarina"); // s12
		Producto pf28 = new Producto ("Piretrinas naturales", "https://es.wikipedia.org/wiki/Piretrina"); // s13
		Producto pf29 = new Producto ("Repelentes", "https://es.wikipedia.org/wiki/Repelente_de_insectos"); // s14
		Producto pf30 = new Producto ("Espinosad", "https://en.wikipedia.org/wiki/Spinosad"); // s15
		
		repoProductos.saveAndFlush(pf1);
		repoProductos.saveAndFlush(pf2);
		repoProductos.saveAndFlush(pf3);
		repoProductos.saveAndFlush(pf4);
		repoProductos.saveAndFlush(pf5);
		repoProductos.saveAndFlush(pf6);
		repoProductos.saveAndFlush(pf7);
		repoProductos.saveAndFlush(pf8);
		repoProductos.saveAndFlush(pf9);
		repoProductos.saveAndFlush(pf10);
		repoProductos.saveAndFlush(pf11);
		repoProductos.saveAndFlush(pf12);
		repoProductos.saveAndFlush(pf13);
		repoProductos.saveAndFlush(pf14);
		repoProductos.saveAndFlush(pf15);
		repoProductos.saveAndFlush(pf16);
		repoProductos.saveAndFlush(pf17);
		repoProductos.saveAndFlush(pf18);
		repoProductos.saveAndFlush(pf19);
		repoProductos.saveAndFlush(pf20);
		repoProductos.saveAndFlush(pf21);
		repoProductos.saveAndFlush(pf22);
		repoProductos.saveAndFlush(pf23);
		repoProductos.saveAndFlush(pf24);
		repoProductos.saveAndFlush(pf25);
		repoProductos.saveAndFlush(pf26);
		repoProductos.saveAndFlush(pf27);
		repoProductos.saveAndFlush(pf28);
		repoProductos.saveAndFlush(pf29);
		repoProductos.saveAndFlush(pf30);

		List<Producto> aux4 = new ArrayList<>();

		aux4.add(pf1);
		aux4.add(pf16);
		s1.setProductos(aux4);
		repoSustancias.saveAndFlush(s1);
		aux4.clear();
		
		aux4.add(pf1);
		aux4.add(pf17);
		s2.setProductos(aux4);
		repoSustancias.saveAndFlush(s2);
		aux4.clear();
		
		aux4.add(pf2);
		aux4.add(pf18);
		s3.setProductos(aux4);
		repoSustancias.saveAndFlush(s3);
		aux4.clear();
		
		aux4.add(pf2);
		aux4.add(pf19);
		s4.setProductos(aux4);
		repoSustancias.saveAndFlush(s4);
		aux4.clear();
		
		aux4.add(pf3);
		aux4.add(pf20);
		s5.setProductos(aux4);
		repoSustancias.saveAndFlush(s5);
		aux4.clear();

		aux4.add(pf3);
		aux4.add(pf21);
		s6.setProductos(aux4);
		repoSustancias.saveAndFlush(s6);
		aux4.clear();
		
		aux4.add(pf4);
		aux4.add(pf22);
		s7.setProductos(aux4);
		repoSustancias.saveAndFlush(s7);
		aux4.clear();
		
		aux4.add(pf4);
		aux4.add(pf23);
		s8.setProductos(aux4);
		repoSustancias.saveAndFlush(s8);
		aux4.clear();
		
		aux4.add(pf5);
		aux4.add(pf24);
		s9.setProductos(aux4);
		repoSustancias.saveAndFlush(s9);
		aux4.clear();
		
		aux4.add(pf5);
		aux4.add(pf25);
		s10.setProductos(aux4);
		repoSustancias.saveAndFlush(s10);
		aux4.clear();

		aux4.add(pf6);
		aux4.add(pf26);
		s11.setProductos(aux4);
		repoSustancias.saveAndFlush(s11);
		aux4.clear();
		
		aux4.add(pf7);
		aux4.add(pf27);
		s12.setProductos(aux4);
		repoSustancias.saveAndFlush(s12);
		aux4.clear();
		
		aux4.add(pf8);
		aux4.add(pf28);
		s13.setProductos(aux4);
		repoSustancias.saveAndFlush(s13);
		aux4.clear();
		
		aux4.add(pf9);
		aux4.add(pf29);
		s14.setProductos(aux4);
		repoSustancias.saveAndFlush(s14);
		aux4.clear();
		
		aux4.add(pf10);
		aux4.add(pf30);
		s15.setProductos(aux4);
		repoSustancias.saveAndFlush(s15);
		aux4.clear();

		aux4.add(pf11);
		s16.setProductos(aux4);
		repoSustancias.saveAndFlush(s16);
		aux4.clear();
		
		aux4.add(pf12);
		s17.setProductos(aux4);
		repoSustancias.saveAndFlush(s17);
		aux4.clear();
		
		aux4.add(pf13);
		s18.setProductos(aux4);
		repoSustancias.saveAndFlush(s18);
		aux4.clear();
		
		aux4.add(pf14);
		s19.setProductos(aux4);
		repoSustancias.saveAndFlush(s19);
		aux4.clear();
		
		aux4.add(pf15);
		s20.setProductos(aux4);
		repoSustancias.saveAndFlush(s20);
		aux4.clear();
		
		
	}                      
}
