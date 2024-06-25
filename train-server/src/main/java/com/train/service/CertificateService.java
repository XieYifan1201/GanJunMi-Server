package com.train.service;

import com.train.dto.CertificateDTO;
import com.train.dto.UserPageQueryDTO;
import com.train.result.PageResult;
import com.train.vo.CertificateVO;

public interface CertificateService {
    /**
     * 通过证书编号获取证书信息
     * @param number
     * @return
     */
    CertificateVO getByNumber(String number);

    /**
     * 添加证书
     * @param certificateDTO
     */
    void save(CertificateDTO certificateDTO);

    /**
     * 分页查询
     * @param pageQueryDTO
     */
    PageResult pageQuery(UserPageQueryDTO pageQueryDTO);

    /**
     * 修改证书
     * @param certificateDTO
     */
    void update(CertificateDTO certificateDTO);

    /**
     * 删除证书
     * @param id
     */
    void delete(Long id);
}
