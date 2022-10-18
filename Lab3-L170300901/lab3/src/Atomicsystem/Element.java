package Atomicsystem;

import java.util.ArrayList;
import java.util.List;

public class Element {

	public String name;//이름,名字
	public int numberofatom;//원자번호
	List<Integer> numberofelecton = new ArrayList<>();//i+1궤도의 존재하는 전자의 갯수
	List<List<Electon>> electon = new ArrayList<>();//궤도 하나당의 전자들의 집합
	
	public Element(String name, int numberofatom, List<Integer> numberofelecton) {
		
		Electon ele = new Electon();
		this.name = name;
		this.numberofatom = numberofatom;
		this.numberofelecton = numberofelecton;
		
		for(int i=0; i<numberofelecton.size(); i++) {//electon 리스트에 번호를 매긴 후 그 번호안에 전자들의 객체를 집어넣는다
			for(int j=0; j<numberofelecton.get(j); j++) {
				electon.get(i).add(j,ele);
				electon.get(i).get(j).numberthoforbit = i;
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int numberofatom() {
		return numberofatom;
	}
	
	public List<Integer> getNumberofeleton(){
		return numberofelecton;
	}
	
}
