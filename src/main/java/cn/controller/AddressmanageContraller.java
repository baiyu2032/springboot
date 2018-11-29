package cn.controller;


import cn.pojo.Address;
import cn.service.AddressmanageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("address/")
@Controller
@Api(value = "address/",description = "������ַ")
public class AddressmanageContraller {

    @Autowired
    @Qualifier("localser")

    private AddressmanageService local;

    public AddressmanageService getAddressmanageService() {
        return this.local;
    }

    public void setAddressmanageService(AddressmanageService addressmanageService) {
        this.local = addressmanageService;
    }

    @ResponseBody
    @RequestMapping(value = "addLocal.html",method = RequestMethod.POST)
    @ApiOperation(value="������ַ",httpMethod="POST",notes="�����������")
    public String addlocal(@ApiParam(required = true, name ="address", value ="��ַ����")@RequestBody Address address){
        return local.addLocal(address);
    }


    @ResponseBody
    @RequestMapping(value = "upDateLocal.html",method= RequestMethod.POST)
    @ApiOperation(value="���µ�ַ",httpMethod="POST",notes="���ظ������")
    public String updateLocal(@ApiParam(required = true, name ="address", value ="��ַ����")@RequestBody Address address){
        return local.updateLocal(address);
    }

    @ResponseBody
    @RequestMapping(value = "delLocal.html/{uid}/{aid}",method = RequestMethod.GET)
    @ApiOperation(value="ɾ����ַ",httpMethod="GET",notes="����ɾ�����")
    public String delLocal(@ApiParam(required = true, name ="uid", value ="�û�ID")@PathVariable("uid")int uid, @ApiParam(required = true, name ="aid", value ="��ַID")@PathVariable("aid")int aid){
        return local.delLocal(uid,aid);
    }

    @ResponseBody
    @RequestMapping(value = "selLocal.html/{uid}",method = RequestMethod.GET)
    @ApiOperation(value="�����û��ջ���ַ",httpMethod="GET",notes="���ز�ѯ���")
    public String selsectlocal(@ApiParam(required = true, name ="uid", value ="�û�ID")@PathVariable("uid") int uid){
     return local.selLocal(uid);
    }

    @ResponseBody
    @RequestMapping(value = "selLocalInfo.html/{aid}/{uid}",method = RequestMethod.GET)
    @ApiOperation(value="�����û������ջ���ַ",httpMethod="GET",notes="���ز�ѯ���")
    public String selLocalInfo(@ApiParam(required = true, name ="aid", value ="��ַID")@PathVariable("aid")int aid, @ApiParam(required = true, name ="uid", value ="�û�ID")@PathVariable("uid")int uid){
        return local.selLoncalinfo(aid,uid);
    }
}