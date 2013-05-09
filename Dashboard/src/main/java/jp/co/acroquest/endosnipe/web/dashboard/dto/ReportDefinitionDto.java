/*
 * Copyright (c) 2004-2013 Acroquest Technology Co., Ltd. All Rights Reserved.
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
package jp.co.acroquest.endosnipe.web.dashboard.dto;


/**
 * レポート出力定義のDtoクラス。
 * 
 * @author miyasaka
 *
 */
public class ReportDefinitionDto
{
    /** レポート出力定義のID。 */
    private int reportId_;

    /** レポート名。 */
    private String reportName_;

    /** レポート出力の対象の計測対象名。 */
    private String targetMeasurementName_;

    /** 期間の始まりの日時。 */
    private String reportTermFrom_;

    /** 期間の終わりの日時。 */
    private String reportTermTo_;

    /**
     * レポート出力定義のIDを取得する。
     *
     * @return レポート出力定義のIDq
     */
    public int getReportId()
    {
        return reportId_;
    }

    /**
     * レポート出力定義のIDを設定する。
     * 
     * @param reportId レポート出力定義のID
     */
    public void setReportId(final int reportId)
    {
        reportId_ = reportId;
    }

    /**
     * レポート名を取得する。
     * 
     * @return レポート名
     */
    public String getReportName()
    {
        return reportName_;
    }

    /**
     * レポート名を設定する。
     * 
     * @param reportName レポート名
     */
    public void setReportName(final String reportName)
    {
        reportName_ = reportName;
    }

    /**
     * レポート出力の対象の計測対象名を取得する。
     * 
     * @return レポート出力の対象の計測対象名
     */
    public String getTargetMeasurementName()
    {
        return targetMeasurementName_;
    }

    /**
     * レポート出力の対象の計測対象名を設定する。
     * 
     * @param targetMeasurementName レポート出力の対象の計測対象名
     */
    public void setTargetMeasurementName(final String targetMeasurementName)
    {
        targetMeasurementName_ = targetMeasurementName;
    }

    /**
     * 期間の始まりの日時を取得する。
     * 
     * @return 期間の始まりの日時
     */
    public String getReportTermFrom()
    {
        return reportTermFrom_;
    }

    /**
     * 期間の始まりの日時を設定する。
     * 
     * @param reportTermFrom 期間の始まりの日時
     */
    public void setReportTermFrom(final String reportTermFrom)
    {
        reportTermFrom_ = reportTermFrom;
    }

    /**
     * 期間の終わりの日時を取得する。
     * 
     * @return 期間の終わりの日時
     */
    public String getReportTermTo()
    {
        return reportTermTo_;
    }

    /**
     * 期間の終わりの日時を設定する。
     * 
     * @param reportTermTo 期間の終わりの日時
     */
    public void setReportTermTo(final String reportTermTo)
    {
        reportTermTo_ = reportTermTo;
    }
}