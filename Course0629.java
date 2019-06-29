private static int find(int [] arr,int searchKey){
    int lowerBound = 0;
	int upperBound = arr.length -1;
	int curIn;
    while(lowerBound <= upperBound){
		curIn = (lowerBound + upperBound) / 2;
		if(arr[curIn] == searchKey){
			return curIn;
		} else {
			if(arr[curIn] < searchKey){
			lowerBound = curIn + 1;
		} else {
			upperBound = curIn - 1;
		}
		}
	}
	return -1;
}


