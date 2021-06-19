package de.unistuttgart.vis.dsass2021.ex06.p4;

public class Sorter {

// author: Siyu Chen (3494095) st169719@stud.uni-stuttgart.de
//         Xuefeng Hou (3502673) st175367@stud.uni-stuttgart.de
//         Leqi Xu (3556962) st176119@stud.uni-stuttgart.de
	public static <T extends Comparable<T>> void heapSort(ISimpleList<T> list) {		
		// AUFGABE 4		
		int len = list.size();
		for(int index = (int)len/2; index >=0; index--){
			int i = index;
			while (2*i+1<=len-1){
				int j = 2*i + 1;
				if(j + 1 <= len - 1 && list.get(j).compareTo(list.get(j+1)) <0){
					j = j + 1;
				}
				if(list.get(i).compareTo(list.get(j))<0){
					list.swap(i, j);
					i = j;
				}else{
					break;
				}
			}
		}

		int l = len - 1;
		while (l >0){
			list.swap(0, l);
			int i = 0;
			while (2*i + 1 <l){
				int j = 2*i + 1;
				if(j + 1 <l && list.get(j).compareTo(list.get(j + 1))<0){
					j = j + 1;
				}
				if(list.get(i).compareTo(list.get(j))<0){
					list.swap(i, j);
					i = j;
				}else{
					break;
				}

			}
			l = l -1;
		}
	}
	

}
