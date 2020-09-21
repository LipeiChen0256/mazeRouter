package com.xilinx.rapidwright.design.task2;

import com.xilinx.rapidwright.design.Design;
import com.xilinx.rapidwright.router.AbstractRouter;
import com.xilinx.rapidwright.router.RouteNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Maze extends AbstractRouter {

    protected PriorityQueue<RouteNode> clockQueue;


    public Maze(){
        super();
    }


    public Maze(Design design){
        super();
        this.design = design;
        dev = design.getDevice();
        clockQueue = new PriorityQueue<RouteNode>(16, new Comparator<RouteNode>() {
            public int compare(RouteNode i, RouteNode j) {return i.getCost() - j.getCost();}});
        //clockQueue is used to save the RouteNodes
    }

    /** methods to be used:
     * getDesign
     * setWireasUsed/unused
     * add/remove used wire mapping
     * get reversed Nodes(Hashmap)
     * get reversed Nodes for Net(Arraylist)
     * is Node used?
     * mark Node used
     * add initial source for Routing
     * prepare sink
     * prepare for routing connection
     * set cost
     * mark inter mediateNode as Used
     * is Clk Pin
    * */
    Maze m = new Maze(design);
    Design des = m.getDesign();
}
