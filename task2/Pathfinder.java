package com.xilinx.rapidwright.task2;

import com.xilinx.rapidwright.design.Design;
import com.xilinx.rapidwright.design.Net;
import com.xilinx.rapidwright.router.AbstractRouter;
import com.xilinx.rapidwright.router.RouteNode;
import com.xilinx.rapidwright.tests.CodePerfTracker;

import java.lang.reflect.Array;
import java.util.*;

/**
 * a Pathfinder (allow overuse, increase penalty over time)
 * use simplified timing model(unit delay)
 */
public class Pathfinder extends AbstractRouter {

    protected PriorityQueue clockQueue;
    protected Collection<Net> nets;
    protected Queue<RouteNode> sinkqueue;
    private Set Crit;


    public Pathfinder(Design design){
        super();
        this.design = design;
        dev= design.getDevice();
        nets = design.getNets();

        clockQueue = new PriorityQueue<RouteNode>(16, new Comparator<RouteNode>() {
            public int compare(RouteNode i, RouteNode j) {return i.getCost() - j.getCost();}});//slack
    }
    public Design connectSinksToSource(){
        return design;
    }
    public int slack(RouteNode i, RouteNode j){
        return i.getCost()-j.getCost();
    }

    /**
     * prepares the nets for routing
     */
    /*public Design routeDesign(){
        identifyMissingPins();
        reserveCriticalNodes();
        markExistingRouteResourcesUsed();
        //stare Routing
        for(Net nn : design.getNets()){
            currNet = nn;  //get the Net to be routed

            //Ignore nets with no pins
            if(currNet.getPins().size()==0){
                continue;
            }

            if(currNet.getPIPs().size()>0)
                continue;


        }
        return design;
    }



    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("USAGE: <input.dcp> <output.dcp>");
        }
        CodePerfTracker t = new CodePerfTracker("Router", true);
        Pathfinder r = new Pathfinder(Design.readCheckpoint(args[0],t));
        t.start("Route Design");
        r.routeDesign();
        t.stop();
        r.getDesign().writeCheckpoint(args[1],t);
    }*/
    public static void main(String[] args) {



    }

}
