package com.xt.controller.qxs;

import com.xt.entity.qxs.warehouse.Depot;
import com.xt.entity.qxs.warehouse.DepotItem;
import com.xt.service.qxs.warehouse.DepotHeadServiceI;
import com.xt.service.qxs.warehouse.DepotItemServiceI;
import com.xt.service.qxs.warehouse.DepotServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.List;

/**
 * @program: xterp
 * @description: 仓库视图操作
 * @author: snow
 * @create: 2019-12-16 08:49
 **/
@Controller
@RequestMapping("depot/")
public class DepotController {

    @Autowired
    private DepotServiceI depotServiceI;
    @Autowired
    private DepotHeadServiceI depotHeadServiceI;
    @Autowired
    private DepotItemServiceI depotItemServiceI;

    /**
     * 跳转至仓库主页
     * @return
     */
    @RequestMapping("pageDepot")
    public String pageDepot(Model model){
        //查询未删除的仓库
        List<Depot> depots = depotServiceI.queryNotDeleteDepot();
        HashMap<Integer, Depot> map = new HashMap<Integer, Depot>();
        for (int i=0;i<depots.size();i++){
            map.put(i,depots.get(i));
        }
        model.addAttribute("depots",map);
        //查询所有单据子表
        List<HashMap> depotItems = depotItemServiceI.queryAllDepotItem();
        model.addAttribute("depotItems",depotItems);
        return "qxs/warehouse/depotMain";
    }
}
