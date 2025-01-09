#include<iostream>
using namespace std;
//single linked list
//define node
class Node
{
    public:
    int key;//data
    Node*next;//address
};
//creating node
Node*newnode(int data)
{
    Node*n=new Node();//object creation
    n-> key=data;//object asign to key
    n->next=NULL;//address field
    return n;
}
//insertion of data
Node*insert_begin(int data,Node*head)
{
    Node*m=newnode(data);
    if(head==NULL)
    {
        head =m;
    }
    else
    {
        m->next=head;
        head=m;
    }
    return head;
}
//insertion at end
Node*insert_end(int data,Node*head)
{
    Node*m=newnode(data);
    if(head==NULL)
    {
        head =m;
    }
    else
    {
        Node*temp=head;
        while(temp->next!=NULL)
        {
            temp=temp->next;
        }
        temp->next=m;
    }
    return head;
}
//insertion at middle
Node*mid_insert(int data,Node*head,int pos)
{
    Node*m=newnode(data);
    if(head==NULL)
    {
        head=m;
    }
    else
        {
         int count=1;        
         Node*temp=head;
         while(temp->next!=NULL)
         {
             count++;
             if(count==pos)
             {
                 break;
             }
             temp=temp->next;
         }
         if(count==pos)
         {
             m->next=temp->next;
             temp->next=m;
         }
         else if(pos==1)
         {
             head=insert_begin(data,head);
         }
         else
         {
           cout<<"invalid"<<endl;  
         }
         //return head;
        }
          return head;
}
//display the list
Node*display(Node*head)
{
    Node*temp=head;
    while(temp!=NULL)
    {
        cout<<temp->key<<"->";
        temp=temp->next;
    }
    cout<<"NULL";
    cout<<endl;
    return head;
}
//deletion at begin
Node*del_begin(Node*head)
{
    if(head==NULL)
    {
        cout<<"list is empty";
    }
    else
    {
        head=head->next;
    }
    return head;
}
//deletion at end
Node*del_end(Node*head)
{
    if(head==NULL)
    {
        cout<<"list is empty";
    }
    if(head->next==NULL)
    {
        head=del_begin(head);
    }
    else
    {
        Node*temp=head;
        while(temp->next->next!=NULL)
        {
           temp=temp->next;
        }
        temp->next=NULL;
    }
    return head;
}
//deletion at middle
Node*del_mid(Node*head,int pos)
{
    if(head==NULL)
    {
        cout<<" Not delete";
    }
    else if(pos==1)
    {
        head=del_begin(head);
    }
    else
    {
        int count=1;
        Node*temp=head;
        while(temp!=NULL)
        {
        count++;
        Node*temp1=temp->next;
        if(count==pos)
        {
            temp->next=temp1->next;
            temp1=NULL;
        }
        temp=temp->next;
    }
    return head;
    }
}
//Searching the element in linked list;
Node*search_element(int data,Node*head)
{
    Node*temp=head;
    int count=0;
    while(temp->next!=NULL)
    {
        if(temp->key==data)
        {
            count++;
            cout<<"yes"<<endl;
        }
        temp=temp->next;
    }
    if(count==0){
        cout<<"no"<<endl;
    }
    return head;
}
//reserve a linked list
Node*reserve(Node*head)
{
    
    if(head==NULL)
    {
        cout<<"List empty"<<endl;
    }
    else if(head->next==NULL)
    {
        cout<<"List contain one value"<<endl;
    }
    else
    {
        Node* temp = NULL;
        Node* temp1 = head;
        Node* temp2 = head->next;
        while(temp2!=NULL)
        {
            temp1->next = temp;
            temp = temp1;
            temp1 = temp2;
            temp2 = temp1->next;
        }
        temp1->next = temp;
        head = temp1;
    }
    return head;
}
//main function
int main()
{
    Node*head=NULL;
    head=insert_begin(30,head);
    head=insert_begin(79,head);
    head=insert_end(3,head);
    head=insert_begin(380,head);
    head=insert_end(392,head);
    head=del_end(head);
    head=del_begin(head);
    head=mid_insert(5,head,1);
    head=insert_end(55,head);
    head=del_mid(head,2);
   //head=search_element(30,head);
    head=display(head);
    head=reserve(head);
    head=display(head);
}
