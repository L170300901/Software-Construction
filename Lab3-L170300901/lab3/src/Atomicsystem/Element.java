package Atomicsystem;

import java.util.ArrayList;
import java.util.List;

public class Element {

	public String name;//�̸�,٣�
	public int numberofatom;//���ڹ�ȣ
	List<Integer> numberofelecton = new ArrayList<>();//i+1�˵��� �����ϴ� ������ ����
	List<List<Electon>> electon = new ArrayList<>();//�˵� �ϳ����� ���ڵ��� ����
	
	public Element(String name, int numberofatom, List<Integer> numberofelecton) {
		
		Electon ele = new Electon();
		this.name = name;
		this.numberofatom = numberofatom;
		this.numberofelecton = numberofelecton;
		
		for(int i=0; i<numberofelecton.size(); i++) {//electon ����Ʈ�� ��ȣ�� �ű� �� �� ��ȣ�ȿ� ���ڵ��� ��ü�� ����ִ´�
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
