/*
 * Copyright (c) 2004-2014 Acroquest Technology Co., Ltd. All Rights Reserved.
 * Please read the associated COPYRIGHTS file for more details.
 *
 * THE  SOFTWARE IS  PROVIDED BY  Acroquest Technology Co., Ltd., WITHOUT  WARRANTY  OF
 * ANY KIND,  EXPRESS  OR IMPLIED,  INCLUDING BUT  NOT LIMITED  TO THE
 * WARRANTIES OF  MERCHANTABILITY,  FITNESS FOR A  PARTICULAR  PURPOSE
 * AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDER BE LIABLE FOR ANY
 * CLAIM, DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package jp.co.acroquest.endosnipe.web.explorer.controller;

import java.util.ArrayList;
import java.util.List;

import jp.co.acroquest.endosnipe.common.logger.ENdoSnipeLogger;
import jp.co.acroquest.endosnipe.web.explorer.config.ConfigurationReader;
import jp.co.acroquest.endosnipe.web.explorer.dto.MethodModelDto;
import jp.co.acroquest.endosnipe.web.explorer.entity.InvocationInfo;
import jp.co.acroquest.endosnipe.web.explorer.service.ProfilerService;
import net.arnx.jsonic.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * プロファイラ機能のコントローラクラス
 * 
 * @author hiramatsu
 */
@Controller
@RequestMapping("/profiler")
public class ProfileController
{
    /** プロファイラ用サービス */
    @Autowired
    protected ProfilerService profilerService_;

    /** ロガー */
    private static final ENdoSnipeLogger LOGGER =
            ENdoSnipeLogger.getLogger(ConfigurationReader.class);

    /**
     * デフォルトコンストラクタ
     */
    public ProfileController()
    {

    }

    /**
     * 「再読み込み」
     * 
     * @param agentName 操作対象のエージェント名
     */
    @RequestMapping(value = "/reload", method = RequestMethod.POST)
    @ResponseBody
    public void reload(@RequestParam(value = "agentName") final String agentName)
    {
        profilerService_.getStatus(agentName);
    }

    /**
     * 「リセット」
     * 
     * @param agentName 通知対象エージェント名
     */
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    @ResponseBody
    public void reset(@RequestParam(value = "agentName") final String agentName)
    {
        profilerService_.resetProfile(agentName);
    }

    /**
     * 「設定を反映」
     * 
     * @param agentName 通知対象エージェント名
     * @param invocations 通知する設定情報
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestParam(value = "agentName") final String agentName,
            @RequestParam(value = "invocations") final String invocations)
    {
        MethodModelDto[] invocationArray = JSON.decode(invocations, MethodModelDto[].class);
        List<InvocationInfo> invocationList = new ArrayList<InvocationInfo>();
        for (MethodModelDto methodModel : invocationArray)
        {
            InvocationInfo info =
                    new InvocationInfo(methodModel.getClassName(), methodModel.getMethodName(),
                                       Boolean.valueOf(methodModel.getTarget()),
                                       Boolean.valueOf(methodModel.getTransactionGraph()),
                                       methodModel.getAlarmThreshold(),
                                       methodModel.getAlarmCpuThreshold());
            invocationList.add(info);
        }
        profilerService_.updateTarget(agentName, invocationList);
    }

}
