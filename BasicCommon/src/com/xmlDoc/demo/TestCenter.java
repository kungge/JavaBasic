package com.xmlDoc.demo;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * XML文件读取
 * @refer http://www.kungge.com/gooditblog/3766.html
 */
public class TestCenter {
    public static void main(String[] args) {
        test1();
    }

    /**
     * DOM方式解析XML
     */
    static void test1(){
        System.out.println("*************test1-start****************");

        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder documentBuilder=dbFactory.newDocumentBuilder();
            Document document=documentBuilder.parse("BasicCommon\\bookData.xml");
            NodeList bookNodeList=document.getElementsByTagName("book");
            System.out.println("书本数量="+bookNodeList.getLength());

            //遍历每一个book节点
            for(int i=0;i<bookNodeList.getLength();i++){
                System.out.println("------遍历第"+(i+1)+"本书的内容-START------");

                Node bookNode=bookNodeList.item(i);

                NamedNodeMap bookNodeAttrs=bookNode.getAttributes();

                System.out.println("第"+(i+1)+"本书共有"+bookNodeAttrs.getLength()+"个属性");

                //遍历属性
                for(int j=0;j<bookNodeAttrs.getLength();j++){
                    Node attr=bookNodeAttrs.item(j);
                    System.out.println("属性名="+attr.getNodeName());
                    System.out.println("属性值="+attr.getNodeValue());
                }

                //获取book节点的子节点
                NodeList bookNode_childNodes=bookNode.getChildNodes();
                System.out.println("第"+(i+1)+"本书共有"+bookNode_childNodes.getLength()+"个子节点");

                for(int k=0;k<bookNode_childNodes.getLength();k++){
                    Node bookNode_childNode=bookNode_childNodes.item(k);

                    // 区分Node类型
                    if(bookNode_childNode.getNodeType()== Node.ELEMENT_NODE){
                        System.out.println("第"+(k+1)+"节点名="+bookNode_childNode.getNodeName());
                        System.out.println("第"+(k+1)+"节点值="+bookNode_childNode.getFirstChild().getNodeValue());
                    }
                }

                System.out.println("------遍历第"+(i+1)+"本书的内容-END------");
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("*************test1-end****************");
    }
}
