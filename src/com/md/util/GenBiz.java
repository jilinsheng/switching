/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.util;

import com.md.model.BizFfxx;
import com.md.model.BizGrffxx;
import com.md.model.BizJtdyzjbhxx;
import com.md.model.BizJtffxx;
import com.md.model.BizJtjzdyxx;
import com.md.model.BizJzbzxx;
import com.md.model.BizJzdxgzdwxx;
import com.md.model.BizJzdxjbxx;
import com.md.model.BizJzdxjyxx;
import com.md.model.BizJzdxsrxx;
import com.md.model.BizJzjtccxx;
import com.md.model.BizJzjtxx;
import com.md.model.BizJzjtzfxx;
import com.md.model.BizRktjxx;
import com.md.model.BizRydyzjbhxx;
import com.md.model.BizRyjzdyxx;
import com.md.model.BizYljztjxx;
import com.md.model.BizZjbfxx;
import com.md.model.BizZjjsxx;
import com.md.model.BizZjlyxx;
import com.md.model.BizZjysxx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author Administrator
 */
public class GenBiz {

    private Document document;
    private String fileName;
    final static String basePath = "D:\\switching\\";

    final static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    final static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    final static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
    final DecimalFormat df1 = new DecimalFormat("###.00");
    final EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("switchPU");

    public GenBiz() {

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public String getSerialno() {
        String sql = "SELECT LPAD(head.nextval, 5, '0') as h FROM DUAL";
        Query q = this.getEntityManager().createNativeQuery(sql);
        String h = q.getSingleResult().toString();
        this.getEntityManager().close();
        return h;
    }

    public void generateBase(String serialno, String xzqhbm, String zone_code, String org_name) {
        try {
            EntityManager em = this.getEntityManager();
            Query query = em.createQuery("SELECT b FROM BizJzjtxx b WHERE b.xzqhbm like :xzqhbm").setParameter("xzqhbm", xzqhbm);
            List<BizJzjtxx> list1 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJzjtccxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizJzjtccxx> list2 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJzjtzfxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizJzjtzfxx> list3 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJzdxjbxx b WHERE b.xzqhbm like :xzqhbm").setParameter("xzqhbm", xzqhbm);
            List<BizJzdxjbxx> list4 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJzdxsrxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizJzdxsrxx> list5 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJzbzxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizJzbzxx> list6 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJzdxjyxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizJzdxjyxx> list7 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJtjzdyxx b WHERE b.oXzqhbm like :xzqhbm").setParameter("xzqhbm", xzqhbm);
            List<BizJtjzdyxx> list8 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizRyjzdyxx b WHERE b.oXzqhbm like :xzqhbm").setParameter("xzqhbm", xzqhbm);
            List<BizRyjzdyxx> list9 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJtdyzjbhxx b WHERE 1<>1");
            List<BizJtdyzjbhxx> list10 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizRydyzjbhxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizRydyzjbhxx> list11 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizFfxx b WHERE b.xzqhbm like :xzqhbm").setParameter("xzqhbm", xzqhbm);
            List<BizFfxx> list12 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJtffxx b WHERE b.oXzqhbm  like :xzqhbm").setParameter("xzqhbm", xzqhbm);
            List<BizJtffxx> list13 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizGrffxx b WHERE b.oXzqhbm like :xzqhbm").setParameter("xzqhbm", xzqhbm);
            List<BizGrffxx> list14 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizZjjsxx b WHERE b.xzqhbm like :xzqhbm").setParameter("xzqhbm", xzqhbm);
            List<BizZjjsxx> list15 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizJzbzxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizJzbzxx> list16 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizZjysxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizZjysxx> list17 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizZjlyxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizZjlyxx> list18 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizZjbfxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizZjbfxx> list19 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizRktjxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizRktjxx> list20 = query.getResultList();

            query = em.createQuery("SELECT b FROM BizYljztjxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BizYljztjxx> list21 = query.getResultList();

            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");

            String xmlns_tns = "http://www.mca.gov.cn/head.xsd/";
            String user_num = "jilin";

            String create_time = sdf2.format(new Date());
            String version_number = serialno;
            String fetch_type = "full";
            String mobile = "18643200627";
            String email = "geogle_jia@126.com";
            String name = "王佳";
            String _dir = zone_code + "_" + sdf1.format(new Date()) + "_" + serialno;
            this.fileName = "head_" + _dir + ".xml";
            Element root = document.addElement("tns:file-head");
            root.addAttribute("xmlns:tns", xmlns_tns);
            Element from_user = root.addElement("from-user");
            from_user.addAttribute("user-num", user_num);
            Element from_org = root.addElement("from-org");
            from_org.addAttribute("zone-code", zone_code);
            from_org.addAttribute("org-name", org_name);
            Element version = root.addElement("version");
            version.addAttribute("version-number", version_number);
            version.addAttribute("create-time", create_time);
            Element data_fetch = root.addElement("data-fetch");
            data_fetch.addAttribute("fetch-type", fetch_type);
            Element contact = root.addElement("contact");
            contact.addAttribute("mobile", mobile);
            contact.addAttribute("email", email);
            contact.addAttribute("name", name);
            Element files_list = root.addElement("files-list");
            Element file1 = files_list.addElement("file");
            String record_num1 = list1.size() + "";
            String file_name1 = "jzjtxx.xml";
            file1.addAttribute("file-name", file_name1);
            file1.addAttribute("record-num", record_num1);
            Element file2 = files_list.addElement("file");
            String record_num2 = list2.size() + "";
            String file_name2 = "jzjtccxx.xml";
            file2.addAttribute("file-name", file_name2);
            file2.addAttribute("record-num", record_num2);
            Element file3 = files_list.addElement("file");
            String record_num3 = list3.size() + "";
            String file_name3 = "jzjtzfxx.xml";
            file3.addAttribute("file-name", file_name3);
            file3.addAttribute("record-num", record_num3);
            Element file4 = files_list.addElement("file");
            String record_num4 = list4.size() + "";
            String file_name4 = "jzdxjbxx.xml";
            file4.addAttribute("file-name", file_name4);
            file4.addAttribute("record-num", record_num4);
            Element file5 = files_list.addElement("file");
            String record_num5 = list5.size() + "";
            String file_name5 = "jzdxsrxx.xml";
            file5.addAttribute("file-name", file_name5);
            file5.addAttribute("record-num", record_num5);
            Element file6 = files_list.addElement("file");
            String record_num6 = list6.size() + "";
            String file_name6 = "jzdxgzdwxx.xml";
            file6.addAttribute("file-name", file_name6);
            file6.addAttribute("record-num", record_num6);
            Element file7 = files_list.addElement("file");
            String record_num7 = list7.size() + "";
            String file_name7 = "jzdxjyxx.xml";
            file7.addAttribute("file-name", file_name7);
            file7.addAttribute("record-num", record_num7);
            Element file8 = files_list.addElement("file");
            String record_num8 = list8.size() + "";
            String file_name8 = "jtjzdyxx.xml";
            file8.addAttribute("file-name", file_name8);
            file8.addAttribute("record-num", record_num8);
            Element file9 = files_list.addElement("file");
            String record_num9 = list9.size() + "";
            String file_name9 = "ryjzdyxx.xml";
            file9.addAttribute("file-name", file_name9);
            file9.addAttribute("record-num", record_num9);
            Element file10 = files_list.addElement("file");
            String record_num10 = list10.size() + "";
            String file_name10 = "jtdyzjbhxx.xml";
            file10.addAttribute("file-name", file_name10);
            file10.addAttribute("record-num", record_num10);
            Element file11 = files_list.addElement("file");
            String record_num11 = list11.size() + "";
            String file_name11 = "rydyzjbhxx.xml";
            file11.addAttribute("file-name", file_name11);
            file11.addAttribute("record-num", record_num11);
            Element file12 = files_list.addElement("file");
            String record_num12 = list12.size() + "";
            String file_name12 = "ffxx.xml";
            file12.addAttribute("file-name", file_name12);
            file12.addAttribute("record-num", record_num12);
            Element file13 = files_list.addElement("file");
            String record_num13 = list13.size() + "";
            String file_name13 = "jtffxx.xml";
            file13.addAttribute("file-name", file_name13);
            file13.addAttribute("record-num", record_num13);
            Element file14 = files_list.addElement("file");
            String record_num14 = list14.size() + "";
            String file_name14 = "grffxx.xml";
            file14.addAttribute("file-name", file_name14);
            file14.addAttribute("record-num", record_num14);
            Element file15 = files_list.addElement("file");
            String record_num15 = list15.size() + "";
            String file_name15 = "zjjsxx.xml";
            file15.addAttribute("file-name", file_name15);
            file15.addAttribute("record-num", record_num15);
            Element file16 = files_list.addElement("file");
            String record_num16 = list16.size() + "";
            String file_name16 = "jzbzxx.xml";
            file16.addAttribute("file-name", file_name16);
            file16.addAttribute("record-num", record_num16);
            Element file17 = files_list.addElement("file");
            String record_num17 = list17.size() + "";
            String file_name17 = "zjysxx.xml";
            file17.addAttribute("file-name", file_name17);
            file17.addAttribute("record-num", record_num17);
            Element file18 = files_list.addElement("file");
            String record_num18 = list18.size() + "";
            String file_name18 = "zjlyxx.xml";
            file18.addAttribute("file-name", file_name18);
            file18.addAttribute("record-num", record_num18);
            Element file19 = files_list.addElement("file");
            String record_num19 = list19.size() + "";
            String file_name19 = "zjbfxx.xml";
            file19.addAttribute("file-name", file_name19);
            file19.addAttribute("record-num", record_num19);
            Element file20 = files_list.addElement("file");
            String record_num20 = list20.size() + "";
            String file_name20 = "rktjxx.xml";
            file20.addAttribute("file-name", file_name20);
            file20.addAttribute("record-num", record_num20);
            Element file21 = files_list.addElement("file");
            String record_num21 = list21.size() + "";
            String file_name21 = "yljztjxx.xml";
            file21.addAttribute("file-name", file_name21);
            file21.addAttribute("record-num", record_num21);

            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(basePath + fileName),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
            File dir = new File(basePath + _dir + "\\");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            this.createJzjtxx(list1, dir.getAbsolutePath());
            this.createJzjtccxx(list2, dir.getAbsolutePath());
            this.createJzjtzfxx(list3, dir.getAbsolutePath());
            this.createJzdxjbxx(list4, dir.getAbsolutePath());
            this.createJzdxsrxx(list5, dir.getAbsolutePath());
            this.createJzbzxx(list6, dir.getAbsolutePath());
            this.createJzdxjyxx(list7, dir.getAbsolutePath());
            this.createJtjzdyxx(list8, dir.getAbsolutePath());
            this.createRyjzdyxx(list9, dir.getAbsolutePath());
            this.createJtdyzjbhxx(list10, dir.getAbsolutePath());
            this.createFfxx(list12, dir.getAbsolutePath());
            this.createJtffxx(list13, dir.getAbsolutePath());
            this.createGrffxx(list14, dir.getAbsolutePath());
            this.createZjjsxx(list15, dir.getAbsolutePath());
            this.createJzbzxx(list16, dir.getAbsolutePath());
            this.createZjysxx(list17, dir.getAbsolutePath());
            this.createZjlyxx(list18, dir.getAbsolutePath());
            this.createZjbfxx(list19, dir.getAbsolutePath());
            this.createRktjxx(list20, dir.getAbsolutePath());
            this.createYljztjxx(list21, dir.getAbsolutePath());

            //  ZipCompressorByAnt z = new ZipCompressorByAnt(basePath + _dir + ".zip");
            //z.compress(basePath + _dir);
            //  ZipCompressor z1=new ZipCompressor(basePath + _dir + ".zip");
            // z1.compress(basePath + _dir);
            ZipUtil.zip(basePath + _dir + ".zip", "", basePath + _dir);

        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //救助家庭信息
    public void createJzjtxx(List<BizJzjtxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jzjtxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <JTLSID>…</JTLSID
            //                    > <HZSFZHM>…</HZSFZHM
            //                    > <JTBM>…</JTBM
            //                    > <JTLB>…</JTLB
            //                    > <ZYZPYY>…</ZYZPYY
            //                    > <JTRK>…</JTRK
            //                    > <BZRK>…</BZRK
            //                    > <ZSR>…</ZSR
            //                    > <XZQHBM>…</XZQHBM
            //                    > <CZRQ>…</CZRQ
            //                    > <JBJGID>…</JBJGID
            //                    > <SPRQ>…</SPRQ
            //                    > <JZYWLX>…</JZYWLX
            //                    > <JZZH>…</JZZH
            //                    > <ZJKM>…</ZJKM
            //                    > <KHYH>…</KHYH
            //                    > <KHMC>…</KHMC
            //                    > <YHZH>…</YHZH
            //                    > <JZDZ>…</JZDZ
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    >

            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzjtxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            for (int i = 0; i < rs.size(); i++) {
                BizJzjtxx s = rs.get(i);
                Element record = root.addElement("Record");
                record.addElement("XH").setText((1 + i) + "");
                record.addElement("JTLSID").setText(s.getJtlsid() + "");
                record.addElement("HZSFZHM").setText(s.getHzsfzhm() + "");
                record.addElement("JTBM").setText(s.getJtbm() + "");
                record.addElement("JTLB").setText(s.getJtlb() + "");
                record.addElement("ZYZPYY").setText(s.getZyzpyy() + "");
                record.addElement("JTRK").setText(s.getJtrk() + "");
                record.addElement("BZRK").setText(s.getBzrk() + "");
                record.addElement("ZSR").setText(s.getZsr() + "");
                record.addElement("XZQHBM").setText(s.getXzqhbm() + "");
                record.addElement("CZRQ").setText(s.getCzrq() + "");
                record.addElement("JBJGID").setText(s.getJbjgid() + "");
                record.addElement("SPRQ").setText(s.getSprq() + "");
                record.addElement("JZYWLX").setText(s.getJzywlx() + "");
                record.addElement("JZZH").setText(s.getJzzh() + "");
                record.addElement("ZJKM").setText(null == s.getZjkm() || s.getZjkm().equals("null") ? "" : s.getZjkm());
                record.addElement("KHYH").setText(null == s.getKhyh() || s.getKhyh().equals("null") ? "" : s.getKhyh());
                record.addElement("KHMC").setText(null == s.getKhmc() || s.getKhmc().equals("null") ? "" : s.getKhmc());
                record.addElement("YHZH").setText(null == s.getYhzh() || s.getYhzh().equals("null") ? "" : s.getYhzh());
                record.addElement("JZDZ").setText(null == s.getJzdz() || s.getJzdz().equals("null") ? "" : s.getJzdz());
                record.addElement("ZLLX").setText(s.getZllx() + "");
                record.addElement("CZSJ").setText(s.getCzsj() + "");
            }
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzjtxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //救助家庭财产信息
    public void createJzjtccxx(List<BizJzjtccxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jzjtccxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <JTCCLSID >…</JTCCLSID
            //                    > <JTLSID>…</JTLSID
            //                    > <CCLX>…</CCLX
            //                    > <CCGZ>…</CCGZ
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    >
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzjtccxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("JTCCLSID").setText(s.getJtcclsid());
                record.addElement("JTLSID").setText(s.getJtlsid());
                record.addElement("CCLX").setText(s.getCclx());
                record.addElement("CCGZ").setText(s.getCcgz() + "");
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzjtccxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //救助家庭住房信息
    public void createJzjtzfxx(List<BizJzjtzfxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jzjtzfxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <JTZFLSID>…</JTZFLSID
            //                    > <JTLSID>…</JTLSID
            //                    > <ZFJG>…</ZFJG
            //                    > <ZFXZ>…</ZFXZ
            //                    > <ZFDZ>…</ZFDZ
            //                    > <JZMJ>…</JZMJ
            //                    > <SYMJ>…</SYMJ
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzjtzfxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("JTZFLSID").setText(s.getJtzflsid());
                record.addElement("JTLSID").setText(s.getJtlsid());
                record.addElement("ZFJG").setText(s.getZfjg());
                record.addElement("ZFXZ").setText(s.getZfxz());
                record.addElement("ZFDZ").setText(s.getZfdz());
                record.addElement("JZMJ").setText(s.getJzmj() + "");
                record.addElement("SYMJ").setText(s.getSymj() + "");
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzjtzfxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //救助对象基本信息
    public void createJzdxjbxx(List<BizJzdxjbxx> rs, String dir) {
        try {
            //        < ? xml  version = "1.0" encoding = "GBK" ? 
            //                > <tns : Data xmlns:
            //        tns = "http://www.mca.gov.cn/jzdxjbxx.xsd/"
            //                > <Record>
            //                < XH >…</XH
            //                > <JTLSID>…</JTLSID
            //                > <RYLSID>…</RYLSID
            //                > <CYSFZHM>…</CYSFZHM
            //                > <RYBM>…</RYBM
            //                > <XM>…</XM
            //                > <XB>…</XB
            //                > <CSRQ>…</CSRQ
            //                > <MZ>…</MZ
            //                > <RYLB>…</RYLB
            //                > <JYZK>…</JYZK
            //                > <HYZK>…</HYZK
            //                > <WHCD>…</WHCD
            //                > <ZZMM>…</ZZMM
            //                > <LDNL>…</LDNL
            //                > <JKZK>…</JKZK
            //                > <SHSW>…</SHSW
            //                > <JTGX>…</JTGX
            //                > <DBZH>…</DBZH
            //                > <HJXZ>…</HJXZ
            //                > <RYZT>…</RYZT
            //                > <XZQHBM>…</XZQHBM
            //                > <CZRQ>…</CZRQ
            //                > <JBJGID>…</JBJGID
            //                > <SFBZDX>…</SFBZDX
            //                > <CJLX>…</CJLX
            //                > <CJDJ>…</CJDJ
            //                > <TDJZDXLB>…</TDJZDXLB
            //                > <GYFS>…</GYFS
            //                > <HJDZ>…</HJDZ
            //                > <SHZLNL>…</SHZLNL
            //                > <GYFWJGID>…</GYFWJGID
            //                > <XYZK>…</XYZK
            //                > <ZLLX>…</ZLLX
            //                > <CZSJ>…</CZSJ
            //                > < / Record
            //                > < / tns:Data >
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzdxjbxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            for (int i = 0; i < rs.size(); i++) {
                BizJzdxjbxx s = rs.get(i);
                Element record = root.addElement("Record");
                record.addElement("XH").setText((i + 1) + "");
                record.addElement("JTLSID").setText(s.getBizJzdxjbxxPK().getJtlsid());
                record.addElement("RYLSID").setText(s.getBizJzdxjbxxPK().getRylsid());
                record.addElement("CYSFZHM").setText(s.getCysfzhm());
                record.addElement("RYBM").setText(s.getRybm());
                record.addElement("XM").setText(s.getXm());
                record.addElement("XB").setText(s.getXb());
                record.addElement("CSRQ").setText(sdf3.format(s.getCsrq()) + "");
                record.addElement("MZ").setText(s.getMz());
                record.addElement("RYLB").setText(s.getRylb());
                record.addElement("JYZK").setText(s.getJyzk());
                record.addElement("HYZK").setText(s.getHyzk());
                record.addElement("WHCD").setText(s.getWhcd());
                record.addElement("ZZMM").setText(s.getZzmm());
                record.addElement("LDNL").setText(s.getLdnl());
                record.addElement("JKZK").setText(s.getJkzk());
                record.addElement("SHSW").setText(s.getShsw());
                record.addElement("JTGX").setText(s.getJtgx());
                record.addElement("DBZH").setText(s.getDbzh());
                record.addElement("HJXZ").setText(s.getHjxz());
                record.addElement("RYZT").setText(s.getRyzt());
                record.addElement("XZQHBM").setText(s.getXzqhbm());
                record.addElement("CZRQ").setText(s.getCzrq());
                record.addElement("JBJGID").setText(s.getJbjgid());
                record.addElement("SFBZDX").setText(s.getSfbzdx());
                record.addElement("CJLX").setText(null == s.getCjlx() || s.getCjlx().equals("null") ? "" : s.getCjlx());
                record.addElement("CJDJ").setText(null == s.getCjdj() || s.getCjdj().equals("null") ? "" : s.getCjdj());
                record.addElement("TDJZDXLB").setText(null == s.getTdjzdxlb() || s.getTdjzdxlb().equals("null") ? "" : s.getTdjzdxlb());
                record.addElement("GYFS").setText(null == s.getGyfs() || s.getGyfs().equals("null") ? "" : s.getGyfs());
                record.addElement("HJDZ").setText(null == s.getHjdz() || s.getHjdz().equals("null") ? "" : s.getHjdz());
                record.addElement("SHZLNL").setText(null == s.getShzlnl() || s.getShzlnl().equals("null") ? "" : s.getShzlnl());
                record.addElement("GYFWJGID").setText(null == s.getGyfwjgid() || s.getGyfwjgid().equals("null") ? "" : s.getGyfwjgid());
                record.addElement("XYZK").setText(null == s.getXyzk() || s.getXyzk().equals("null") ? "" : s.getXyzk());
                record.addElement("ZLLX").setText(null == s.getZllx() || s.getZllx().equals("null") ? "" : s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
                i++;
            }
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzdxjbxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //救助对象收入信息
    public void createJzdxsrxx(List<BizJzdxsrxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jzdxsrxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <JZDXSRLSID>…</JZDXSRLSID
            //                    > <RYLSID>…</RYLSID
            //                    > <CYSFZHM>…</CYSFZHM
            //                    > <SRLX>…</SRLX
            //                    > <YSRJE>…</YSRJE
            //                    > <NSRJE>…</NSRJE
            //                    > <YJRJE>…</YJRJE
            //                    > < NJRJE>…</ NJRJE
            //                    > <SRJSFS>…</SRJSFS
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzdxsrxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("JZDXSRLSID").setText(s.getJzdxsrlsid());
                record.addElement("RYLSID").setText(s.getRylsid());
                record.addElement("CYSFZHM").setText(s.getCysfzhm());
                record.addElement("SRLX").setText(s.getSrlx());
                record.addElement("YSRJE").setText(df1.format(s.getYsrje()));
                record.addElement("NSRJE").setText(df1.format(s.getNsrje()));
                record.addElement("YJRJE").setText(df1.format(s.getYjrje()));
                record.addElement("NJRJE").setText(df1.format(s.getNjrje()));
                record.addElement("SRJSFS").setText(s.getSrjsfs());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzdxsrxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //救助对象工作单位信息
    public void createJzdxgzdwxx(List<BizJzdxgzdwxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jzdxgzdwxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <GZDWLSID>…</GZDWLSID
            //                    > <RYLSID>…</RYLSID
            //                    > <CYSFZHM>…</CYSFZHM
            //                    > <DWMC>…</DWMC
            //                    > <DWXZ>…</DWXZ
            //                    > <LXDH>…</LXDH
            //                    > <DZ>…</DZ
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    >
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzdxgzdwxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("GZDWLSID").setText(s.getGzdwlsid());
                record.addElement("RYLSID").setText(s.getRylsid());
                record.addElement("CYSFZHM").setText(s.getCysfzhm());
                record.addElement("DWMC").setText(s.getDwmc());
                record.addElement("DWXZ").setText(s.getDwxz());
                record.addElement("LXDH").setText(s.getLxdh());
                record.addElement("DZ").setText(s.getDz());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzdxgzdwxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //救助对象教育信息
    public void createJzdxjyxx(List<BizJzdxjyxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jzdxjyxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <JYLSID>…</JYLSID
            //                    > <RYLSID>…</RYLSID
            //                    > <CYSFZHM>…</CYSFZHM
            //                    > <XXMC>…</XXMC
            //                    > <XXLB>…</XXLB
            //                    > <RXSJ>…</RXSJ
            //                    > <BYSJ>…</BYSJ
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzdxjyxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("JYLSID").setText(s.getBizJzdxjyxxPK().getJylsid());
                record.addElement("RYLSID").setText(s.getBizJzdxjyxxPK().getRylsid());
                record.addElement("CYSFZHM").setText(s.getCysfzhm());
                record.addElement("XXMC").setText(s.getXxmc());
                record.addElement("XXLB").setText(s.getXxlb());
                record.addElement("RXSJ").setText(s.getRxsj());
                record.addElement("BYSJ").setText(s.getBysj());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzdxjyxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //家庭救助待遇信息
    public void createJtjzdyxx(List<BizJtjzdyxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jtjzdyxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <JTLSID>…</JTLSID
            //                    > <KSNY>…</KSNY
            //                    > <JSNY>…</JSNY
            //                    > <JZSW>…</JZSW
            //                    > <SL>…</SL
            //                    > <DW>…</DW
            //                    > <JZJE>…</JZJE
            //                    > <JZYWLX>…</JZYWLX
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    >
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jtjzdyxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            for (int i = 0; i < rs.size(); i++) {
                BizJtjzdyxx s = rs.get(i);
                Element record = root.addElement("Record");
                record.addElement("XH").setText((i + 1) + "");
                record.addElement("JTLSID").setText(s.getJtlsid());
                record.addElement("KSNY").setText(s.getKsny());
                record.addElement("JSNY").setText(s.getJsny());
                record.addElement("JZSW").setText(null == s.getJzsw() || s.getJzsw().equals("null") ? "" : s.getJzsw());
                record.addElement("SL").setText(null == (s.getSl() + "") || (s.getSl() + "").equals("null") ? "" : (s.getSl() + ""));
                record.addElement("DW").setText(null == s.getDw() || s.getDw().equals("null") ? "" : s.getDw());
                record.addElement("JZJE").setText(df1.format(s.getJzje()));
                record.addElement("JZYWLX").setText(s.getJzywlx());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            }

            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jtjzdyxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //人员救助待遇信息
    public void createRyjzdyxx(List<BizRyjzdyxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/ryjzdyxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <RYLSID>…</RYLSID
            //                    > <CYSFZHM>…</CYSFZHM
            //                    > <KSNY>…</KSNY
            //                    > <JSNY>…</JSNY
            //                    > <JZSW>…</JZSW
            //                    > <SL>…</SL
            //                    > <DW>…</DW
            //                    > <JZJE>…</JZJE
            //                    > <DYSS>…</DYSS
            //                    > <JZYWLX>…</JZYWLX
            //                    > <JZXMBM>…</JZXMBM
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    >
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/ryjzdyxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            for (int i = 0; i < rs.size(); i++) {
                BizRyjzdyxx s = rs.get(i);
                Element record = root.addElement("Record");
                record.addElement("XH").setText((i + 1) + "");
                record.addElement("RYLSID").setText(s.getBizRyjzdyxxPK().getRylsid());
                record.addElement("CYSFZHM").setText(s.getCysfzhm());
                record.addElement("KSNY").setText(s.getKsny());
                record.addElement("JSNY").setText(s.getJsny());
                record.addElement("JZSW").setText(null == s.getJzsw() || s.getJzsw().equals("null") ? "" : s.getJzsw());
                record.addElement("SL").setText(null == (s.getSl() + "") || (s.getSl() + "").equals("null") ? "" : (s.getSl() + ""));
                record.addElement("DW").setText(null == s.getDw() || s.getDw().equals("null") ? "" : s.getDw());
                record.addElement("JZJE").setText(df1.format(s.getJzje()));
                record.addElement("DYSS").setText(s.getDyss());
                record.addElement("JZYWLX").setText(s.getJzywlx());
                record.addElement("JZXMBM").setText(s.getJzxmbm());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            }
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//ryjzdyxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //家庭待遇增减变化信息
    public void createJtdyzjbhxx(List<BizJtdyzjbhxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jtdyzjbhxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <JTLSID>…</JTLSID
            //                    > <BHLX>…</BHLX
            //                    > <ZJBHJE>…</ZJBHJE
            //                    > <BHRQ>…</BHRQ
            //                    > <SXNY>…</SXNY
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jtdyzjbhxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText("");
                record.addElement("JTLSID").setText(s.getBizJtdyzjbhxxPK().getJtlsid());
                record.addElement("BHLX").setText(s.getBhlx());
                record.addElement("ZJBHJE").setText(df1.format(s.getZjbhje()));
                record.addElement("BHRQ").setText(s.getBhrq());
                record.addElement("SXNY").setText(s.getSxny());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jtdyzjbhxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //人员待遇增减变化信息
    public void createRydyzjbhxx(List<BizRydyzjbhxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/rydyzjbhxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <RYLSID>…</RYLSID
            //                    > <CYSFZHM>…</CYSFZHM
            //                    > <BHLX>…</BHLX
            //                    > <ZJBHJE>…</ZJBHJE
            //                    > <BHRQ>…</BHRQ
            //                    > <SXNY>…</SXNY
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/rydyzjbhxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("RYLSID").setText(s.getRylsid());
                record.addElement("CYSFZHM").setText(s.getCysfzhm());
                record.addElement("BHLX").setText(s.getBhlx());
                record.addElement("ZJBHJE").setText(df1.format(s.getZjbhje()));
                record.addElement("BHRQ").setText(s.getBhrq());
                record.addElement("SXNY").setText(s.getSxny());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//rydyzjbhxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //发放信息数据
    public void createFfxx(List<BizFfxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/ffxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <FFXXID>…</FFXXID
            //                    > <ZJZHID >…</ZJZHID
            //                    > <FFNY >…</FFNY
            //                    > <FFJE >…</ FFJE
            //                    > <FFRS >…</FFRS
            //                    > <FFLX >…</ FFLX
            //                    > <JBR >…</JBR
            //                    > <SPR >…</SPR
            //                    > <FFZT >…</FFZT
            //                    > <FFFS >…</ FFFS
            //                    > <JZYWBM >…</ JZYWBM
            //                    > <BZ >…</BZ
            //                    > <CZY >…</ CZY
            //                    > <JBJG >…</ JBJG
            //                    > <XZQHBM >…</XZQHBM
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/ffxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            root.setText("");
            for (int i = 0; i < rs.size(); i++) {
                BizFfxx s = rs.get(i);
                Element record = root.addElement("Record");
                record.addElement("XH").setText((i + 1) + "");
                record.addElement("FFXXID").setText(s.getFfxxid());
                record.addElement("ZJZHID").setText(null == s.getZjzhid() || s.getZjzhid().equals("null") ? "null" : s.getZjzhid());
                record.addElement("FFNY").setText(s.getFfny());
                record.addElement("FFJE").setText(df1.format(s.getFfje()));
                record.addElement("FFRS").setText(s.getFfrs() + "");
                record.addElement("FFLX").setText(s.getFflx());
                record.addElement("JBR").setText(null == s.getJbr() || s.getJbr().equals("null") ? "" : s.getJbr());
                record.addElement("SPR").setText(null == s.getSpr() || s.getSpr().equals("null") ? "" : s.getSpr());
                record.addElement("FFZT").setText(s.getFfzt() + "");
                record.addElement("FFFS").setText(s.getFffs());
                record.addElement("JZYWBM").setText(s.getJzywbm());
                record.addElement("BZ").setText(null == s.getBz() || s.getBz().equals("null") ? "" : s.getBz());
                record.addElement("CZY").setText(null == s.getCzy() || s.getCzy().equals("null") ? "" : s.getCzy());
                record.addElement("JBJG").setText(null == s.getJbjg() || s.getJbjg().equals("null") ? "" : s.getJbjg());
                record.addElement("XZQHBM").setText(s.getXzqhbm());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            }

            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//ffxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //家庭发放信息
    public void createJtffxx(List<BizJtffxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jtffxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <JTFFXXID>…</ JTFFXXID
            //                    > <FFXXID >…</ FFXXID
            //                    > <ZJJSXXID >…</ZJJSXXID
            //                    > <FFJE >…</ FFJE
            //                    > <JTBM >…</ JTBM
            //                    > <HZID >…</HZID
            //                    > <FFYHZHID >…</FFYHZHID
            //                    > <FFRS >…</FFRS
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jtffxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            for (int i = 0; i < rs.size(); i++) {
                BizJtffxx s = rs.get(i);
                Element record = root.addElement("Record");
                record.addElement("XH").setText((i + 1) + "");
                record.addElement("JTFFXXID").setText(null == s.getJtffxxid() || s.getJtffxxid().equals("null") ? "" : s.getJtffxxid());
                record.addElement("FFXXID").setText(s.getFfxxid());
                record.addElement("ZJJSXXID").setText(null == s.getZjjsxxid() || s.getZjjsxxid().equals("null") ? "" : s.getZjjsxxid());
                record.addElement("FFJE").setText(df1.format(s.getFfje()));
                record.addElement("JTBM").setText(s.getJtbm());
                record.addElement("HZID").setText(s.getHzid());
                record.addElement("FFYHZHID").setText(null == s.getFfyhzhid() || "".equals(s.getFfyhzhid()) ? "" : s.getFfyhzhid());
                record.addElement("FFRS").setText(s.getFfrs() + "");
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            }
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jtffxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //个人发放信息
    public void createGrffxx(List<BizGrffxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/grffxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <GRFFXXID>…</ GRFFXXID
            //                    > <FFXXID >…</ FFXXID
            //                    > <JTFFXXID >…</ JTFFXXID
            //                    > <ZJJSXXID >…</ZJJSXXID
            //                    > <FFJE >…</ FFJE
            //                    > <RYBM >…</ RYBM
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/grffxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            for (int i = 0; i < rs.size(); i++) {
                BizGrffxx s = rs.get(i);
                Element record = root.addElement("Record");
                record.addElement("XH").setText((i + 1) + "");
                record.addElement("GRFFXXID").setText(s.getGrffxxid());
                record.addElement("FFXXID").setText(s.getFfxxid());
                record.addElement("JTFFXXID").setText(s.getJtffxxid());
                record.addElement("ZJJSXXID").setText(s.getZjjsxxid() + "");
                record.addElement("FFJE").setText(df1.format(s.getFfje()));
                record.addElement("RYBM").setText(s.getRybm());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            }
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//grffxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //资金结算信息
    public void createZjjsxx(List<BizZjjsxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/zjjsxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <ZJJSXXID >…</ ZJJSXXID
            //                    > <JSKSNY >…</JSKSNY
            //                    > <JSRQ >…</ JSRQ
            //                    > <JSJE >…</ JSJE
            //                    > <JSBM >…</JSBM
            //                    > < JSJSNY>…</ JSJSNY
            //                    > <JZYWBM >…</ JZYWBM
            //                    > <JBJG >…</JBJG
            //                    > <XZQHBM >…</XZQHBM
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/zjjsxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            for (int i = 0; i < rs.size(); i++) {
                BizZjjsxx s = rs.get(i);
                Element record = root.addElement("Record");
                record.addElement("XH").setText((i + 1) + "");
                record.addElement("ZJJSXXID").setText(s.getZjjsxxid());
                record.addElement("JSKSNY").setText(s.getJsksny());
                record.addElement("JSRQ").setText(s.getJsrq());
                record.addElement("JSJE").setText(df1.format(s.getJsje()));
                record.addElement("JSBM").setText(s.getJsbm() + "");
                record.addElement("JSJSNY").setText(s.getJsjsny());
                record.addElement("JZYWBM").setText(s.getJzywbm());
                record.addElement("JBJG").setText(null == s.getJbjg() || s.getJbjg().equals("null") ? "" : s.getJbjg());
                record.addElement("XZQHBM").setText(s.getXzqhbm());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            }

            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//zjjsxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //救助标准信息
    public void createJzbzxx(List<BizJzbzxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/jzbzxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <BZJE>…</BZJE
            //                    > <QYRQ>…</QYRQ
            //                    > <FZRQ>…</FZRQ
            //                    > <FBWJH>…</FBWJH
            //                    > <JZYWLX>…</JZYWLX
            //                    > <JZBZLX>…</JZBZLX
            //                    > <JGID>…</JGID
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzbzxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("BZJE").setText(s.getBzje());
                record.addElement("QYRQ").setText(s.getQyrq());
                record.addElement("FZRQ").setText(s.getFzrq());
                record.addElement("FBWJH").setText(s.getFbwjh());
                record.addElement("JZYWLX").setText(s.getJzywlx());
                record.addElement("JZBZLX").setText(s.getJzbzlx());
                record.addElement("JGID").setText(s.getJgid());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzbzxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //资金预算信息
    public void createZjysxx(List<BizZjysxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/zjysxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <ZJKM>…</ZJKM
            //                    > <BJYSJE>…</BJYSJE
            //                    > <ZJYSND>…</ZJYSND
            //                    > <SJYSJE>…</SJYSJE
            //                    > <JGID>…</JGID
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/zjysxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("ZJKM").setText(s.getZjkm());
                record.addElement("BJYSJE").setText(df1.format(s.getBjysje()));
                record.addElement("ZJYSND").setText(s.getZjysnd());
                record.addElement("SJYSJE").setText(df1.format(s.getSjysje()));
                record.addElement("JGID").setText(s.getJgid());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//zjysxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //资金来源信息
    public void createZjlyxx(List<BizZjlyxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/zjlyxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <ZJKM>…</ZJKM
            //                    > <ZJLY>…</ZJLY
            //                    > <JE>…</JE
            //                    > <ZJDZRQ>…</ZJDZRQ
            //                    > <JGID>…</JGID
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/zjlyxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("ZJKM").setText(s.getZjkm());
                record.addElement("ZJLY").setText(s.getZjly());
                record.addElement("JE").setText(df1.format(s.getJe()));
                record.addElement("ZJDZRQ").setText(s.getZjdzrq());
                record.addElement("JGID").setText(s.getJgid());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//zjlyxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //资金拨付信息
    public void createZjbfxx(List<BizZjbfxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/zjbfxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <ZJKM>…</ZJKM
            //                    > <BFRQ>…</BFRQ
            //                    > <JSJG>…</JSJG
            //                    > <BFJE>…</BFJE
            //                    > <BFWJMC>…</BFWJMC
            //                    > <BFWJH>…</BFWJH
            //                    > <JGID>…</JGID
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    >
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/zjbfxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("ZJKM").setText(s.getZjkm());
                record.addElement("BFRQ").setText(s.getBfrq());
                record.addElement("JSJG").setText(s.getJsjg());
                record.addElement("BFJE").setText(df1.format(s.getBfje()));
                record.addElement("BFWJMC").setText(s.getBfwjmc());
                record.addElement("BFWJH").setText(s.getBfwjh());
                record.addElement("JGID").setText(s.getJgid());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//zjbfxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //人口统计信息
    public void createRktjxx(List<BizRktjxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/rktjxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <QXXZQHBM>…</QXXZQHBM
            //                    > <FNYRKS>…</FNYRKS
            //                    > <NYRKS>…</NYRKS
            //                    > <TJND>…</TJND
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/rktjxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("QXXZQHBM").setText(s.getQxxzqhbm());
                record.addElement("FNYRKS").setText(s.getFnyrks() + "");
                record.addElement("NYRKS").setText(s.getNyrks() + "");
                record.addElement("TJND").setText(s.getTjnd());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//rktjxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //医疗救助统计信息
    public void createYljztjxx(List<BizYljztjxx> rs, String dir) {
        try {
            //            < ? xml  version = "1.0" encoding = "GBK" ? 
            //                    > <tns : Data xmlns:
            //            tns = "http://www.mca.gov.cn/yljztjxx.xsd/"
            //                    > <Record>
            //                    < XH >…</XH
            //                    > <QXXZQHBM>…</QXXZQHBM
            //                    > <YNRCSYLDBRS>…</YNRCSYLDBRS
            //                    > <YNRNCYLDBRS>…</YNRNCYLDBRS
            //                    > <MZJZNFDX>…</MZJZNFDX
            //                    > <ZYJZNFDX>…</ZYJZNFDX
            //                    > <PJJZBL>…</PJJZBL
            //                    > <MZJZQFX>…</MZJZQFX
            //                    > <ZYJZQFX>…</ZYJZQFX
            //                    > <TJND>…</TJND
            //                    > <ZLLX>…</ZLLX
            //                    > <CZSJ>…</CZSJ
            //                    > < / Record
            //                    > < / tns
            //            :Data
            //                    > 
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/yljztjxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            root.setText("");
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("QXXZQHBM").setText(s.getQxxzqhbm());
                record.addElement("YNRCSYLDBRS").setText(s.getYnrcsyldbrs() + "");
                record.addElement("YNRNCYLDBRS").setText(s.getYnrncyldbrs() + "");
                record.addElement("MZJZNFDX").setText(s.getMzjznfdx().toString());
                record.addElement("ZYJZNFDX").setText(s.getZyjznfdx().toString());
                record.addElement("PJJZBL").setText(s.getPjjzbl().toString());
                record.addElement("MZJZQFX").setText(s.getMzjzqfx().toString());
                record.addElement("ZYJZQFX").setText(s.getZyjzqfx().toString());
                record.addElement("TJND").setText(s.getTjnd());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//yljztjxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("Convert2Diamond")
    public List<Object[]> createAll() {
        String sql = "select substr(t.xzqhbm, 1, 6) as a, t.xzqhmc as b   from base_xzqhxx t  where  t.xzqhbm like '22%' and  t.xzjb = '4'    and instr(t.xzqhmc, '本级') = 0 order by  substr(t.xzqhbm, 1, 6)";
        Query q = this.getEntityManager().createNativeQuery(sql);
        List<Object[]> list = q.getResultList();
        this.getEntityManager().close();
        return list;
    }

    public static void main(String args[]) {
        GenBiz gb = new GenBiz();
        List<Object[]> list = gb.createAll();
        list.stream().forEach((s) -> {
            gb.generateBase(gb.getSerialno(), s[0].toString() + "%", s[0].toString(), s[1].toString());
        });
    }
}
