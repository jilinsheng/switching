/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 <?xml version="1.0" encoding="GBK"?>
 <tns:file-head xmlns:tns="http://www.mca.gov.cn/head.xsd/" >
 <from-user user-num="" />
 <from-org org-name="" zone-code=""/>
 <version version-number="" create-time=""/>
 <data-fetch fetch-type=""/>
 <contact name="" email="" mobile=""/>
 <files-list>
 <file file-name="xzqhxx.xml" record-num=""/>
 <file file-name="jzjgxx.xml" record-num=""/>
 <file file-name="gyjgxx.xml" record-num=""/>
 </files-list>
 </tns:file-head>
 */
package com.md.util;

import com.md.model.BaseGyjgxx;
import com.md.model.BaseJzjgxx;
import com.md.model.BaseXzqhxx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
 * 吉林省	220000000000	092E09FB4CA94B7CAF03111758CB34E6 吉林省民政厅
 * 4028a1202c3481dd012c349d4e90000f
 *
 * @author jia
 */
public class GenBase {

    private Document document;
    private String fileName;
    final static String basePath = "D:\\switching\\";

    final static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    final static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    final EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("switchPU");

    public GenBase() {

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

    public void generateBase(String serialno) {
        try {
            EntityManager em = this.getEntityManager();
            Query query = em.createQuery("SELECT b FROM BaseXzqhxx b WHERE b.xzqhbm<> :xzqhbm order by b.xh asc").setParameter("xzqhbm", "220000000000");
            List<BaseXzqhxx> list1 = query.getResultList();

            query = em.createQuery("SELECT b FROM BaseJzjgxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BaseJzjgxx> list2 = query.getResultList();

            query = em.createQuery("SELECT b FROM BaseGyjgxx b WHERE b.xh = :xh").setParameter("xh", -1);
            List<BaseGyjgxx> list3 = query.getResultList();

            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");

            String xmlns_tns = "http://www.mca.gov.cn/head.xsd/";
            String user_num = "jilin";
            String zone_code = "22";
            String org_name = "吉林省";
            String create_time = sdf2.format(new Date());
            String version_number = serialno;
            String fetch_type = "full";
            String mobile = "18643200627";
            String email = "geogle_jia@126.com";
            String name = "王佳";
            String xzqhbm = "22";
            String _dir = xzqhbm + "_" + sdf1.format(new Date()) + "_" + serialno;
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
            String file_name1 = "xzqhxx.xml";
            file1.addAttribute("file-name", file_name1);
            file1.addAttribute("record-num", record_num1);
            Element file2 = files_list.addElement("file");
            String record_num2 = list2.size() + "";
            String file_name2 = "jzjgxx.xml";
            file2.addAttribute("file-name", file_name2);
            file2.addAttribute("record-num", record_num2);
            Element file3 = files_list.addElement("file");
            String record_num3 = list3.size() + "";
            String file_name3 = "gyjgxx.xml";
            file3.addAttribute("file-name", file_name3);
            file3.addAttribute("record-num", record_num3);
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
            this.createXzqhxx(list1, dir.getAbsolutePath());
            this.createJzjgxx(list2, dir.getAbsolutePath());
            this.createGyjgxx(list3, dir.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createXzqhxx(List<BaseXzqhxx> rs, String dir) {

        try {
            //  <?xml version="1.0" encoding="GBK"?>
//<tns:Data xmlns:tns="http://www.mca.gov.cn/xzqhxx.xsd/" >
//<Record>
            //<XH>…</XH>
//<XZQHID>…</XZQHID>
            //<XZQHBM>…</XZQHBM>
            //<XZQHMC>…</XZQHMC>
            //<XZJB>…</XZJB>
            //<SJXZQHID>…</SJXZQHID>
            //<ZT>…</ZT>
//<ZLLX>…</ZLLX>
//CZSJ>…</CZSJ>
            //</Record>
//</tns:Data>
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/xzqhxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);

            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                record.addElement("XH").setText(s.getXh() + "");
                record.addElement("XZQHID").setText(s.getXzqhid());
                record.addElement("XZQHBM").setText(s.getXzqhbm());
                record.addElement("XZQHMC").setText(s.getXzqhmc());
                record.addElement("XZJB").setText(s.getXzjb());
                record.addElement("SJXZQHID").setText(s.getSjxzqhid());
                record.addElement("ZT").setText(s.getZt());
                record.addElement("ZLLX").setText(s.getZllx());
                record.addElement("CZSJ").setText(s.getCzsj());
            });
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//xzqhxx.xml"),
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

    public void createJzjgxx(List<BaseJzjgxx> rs, String dir) {
        try {
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/jzjgxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);

            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                
            });
            root.setText("");
            
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//jzjgxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createGyjgxx(List<BaseGyjgxx> rs, String dir) {
        try {
            document = DocumentHelper.createDocument();
            document.setXMLEncoding("GBK");
            String xmlns_tns = "http://www.mca.gov.cn/gyjgxx.xsd/";
            Element root = document.addElement("tns:Data");
            root.addAttribute("xmlns:tns", xmlns_tns);
            
            rs.stream().forEach((s) -> {
                Element record = root.addElement("Record");
                
            });
            root.setText("");
             
            OutputFormat of = new OutputFormat();
            of.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dir + "//gyjgxx.xml"),
                    of);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        GenBase gb = new GenBase();
        gb.generateBase(gb.getSerialno());
    }
}
