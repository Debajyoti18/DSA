public int kthFromLast(int k){
    Node t = head;
    int len = 0;
    while(t != null){
        len++;
        t = t.next;
    }
    int index = len - k ;
    t=head;
    for(int i =0;i < index;i++){
       t = t.next;
    }
    return t.data;
}