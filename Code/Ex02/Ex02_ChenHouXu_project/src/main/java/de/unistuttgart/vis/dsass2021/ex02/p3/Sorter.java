package de.unistuttgart.vis.dsass2021.ex02.p3;

public class Sorter {
		
	public static <T extends Comparable<T>> void selectionSort(ISimpleList<T> list) {
		int len = list.size();
		for(int i = 0; i< len; i ++){
			int maxId = i;
			for(int j = i; j < len; j++){
				if(list.get(j).compareTo(list.get(maxId)) > 0 ){
					maxId = j;
				}
			}
			list.swap(i, maxId);
		}
	}
	
	public static <T extends Comparable<T>> void insertionSort(ISimpleList<T> list) {
		int len = list.size();
		for(int i = 1; i < len; i ++){
			for(int j = i; j> 0; j--){
				if(list.get(j).compareTo(list.get(j-1))>0){
					list.swap(j, j-1);
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void bubbleSort(ISimpleList<T> list) {
		int len = list.size();
		for(int i = 0; i < len-1; i ++){
			boolean swapFlag = false;
			for(int j = 0; j < len- 1 - i; j ++){
				if(list.get(j).compareTo(list.get(j + 1))<0){
					list.swap(j, j+1);
					swapFlag = true;
				}
			}
			if(!swapFlag){
				break;
			}
		}
	}

}
