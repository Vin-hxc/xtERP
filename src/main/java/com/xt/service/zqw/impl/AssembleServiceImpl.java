package com.xt.service.zqw.impl;

import com.xt.entity.qxs.warehouse.Depothead;
import com.xt.entity.zqw.Assemble;
import com.xt.mapper.zqw.AssembleMapper;
import com.xt.mapper.zqw.DispatchedworkerMapper;
import com.xt.service.zqw.AssembleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class AssembleServiceImpl implements AssembleServiceI {
    @Autowired
    private AssembleMapper assembleMapper;

    @Override
    public boolean inserAssemble(Assemble assemble) {
        return assembleMapper.inserAssemble(assemble);
    }

    @Override
    public List<HashMap> seleAssem() {
        return assembleMapper.seleAssem();
    }

    @Override
    public List<HashMap> seledepothead(int id) {
        return assembleMapper.seledepothead(id);
    }

    @Override
    public List<HashMap> seleProi(int id) {
        return assembleMapper.seleProi(id);
    }

    @Override
    public List<HashMap> seleDep(int id) {
        return assembleMapper.seleDep(id);
    }

    @Override
    public boolean AssemSh(int id, int qualityTesting) {
        return assembleMapper.AssemSh(id,qualityTesting);
    }

    /**
     * 入库
     * @param depothead
     * @return
     */
    @Override
    public boolean inserDepths(Depothead depothead) {
        assembleMapper.inserDepths(depothead);
        return false;
    }
}
