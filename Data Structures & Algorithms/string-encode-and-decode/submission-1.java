class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuild = new StringBuilder();
        for(String str : strs){
            strBuild.append(str.length());
            strBuild.append("#");
            strBuild.append(str);
        }
        //5#Hello5#World
        return strBuild.toString();
    }

    public List<String> decode(String str) {
        int leftPointer = 0;
        
        ArrayList<String> resultList = new ArrayList<>();
        while(leftPointer < str.length()){
           int rightPointer = leftPointer;
           while(str.charAt(rightPointer) != '#'){
                rightPointer++;
           }
           int length = Integer.parseInt(str.substring(leftPointer,rightPointer));
           rightPointer++;
           resultList.add(str.substring(rightPointer, rightPointer+length));
           leftPointer = rightPointer + length;

        }
        return resultList;
    }
}
