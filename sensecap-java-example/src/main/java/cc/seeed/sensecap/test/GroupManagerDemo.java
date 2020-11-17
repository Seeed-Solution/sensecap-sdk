package cc.seeed.sensecap.test;

import cc.seeed.sensecap.SenseCAPClient;
import cc.seeed.sensecap.SenseCAPClientBuilder;
import cc.seeed.sensecap.common.enums.RegionType;
import cc.seeed.sensecap.config.OpenApiConfig;
import cc.seeed.sensecap.exception.BaseException;
import cc.seeed.sensecap.manager.GroupManager;
import cc.seeed.sensecap.model.group.GroupInfo;
import cc.seeed.sensecap.model.result.GroupResult;

import java.util.List;

/**
 * @Author AG
 * @Description
 * @Date 2020/8/25 13:44
 * @Version V1.0
 */
public class GroupManagerDemo {


    private static SenseCAPClient senseCAPClient;

    static {
        String accessId = "KUFE0W52P8QJX8DB";
        String accessKey = "28E07CA0D52B48C69886D7ACF1AD683F3690EE0E1E0C4201B88A26A61344625C";
        int region = RegionType.SENSECAP_CC.getRegion();
        OpenApiConfig openApiConfig = new OpenApiConfig(accessId, accessKey, region);
        senseCAPClient = new SenseCAPClientBuilder().buildConfig(openApiConfig);
    }

    public static void main(String[] args) throws BaseException {
        //方法测试
        //createGroup( );
        //removeGroup();
        //renameGroup();
        getGroupList();
    }

    public static void createGroup() throws BaseException {
        GroupInfo result = senseCAPClient.getGroupManager().createGroupQuery().groupName("SDK-5").build().create();
        System.out.println(result);
    }

    public static void renameGroup() throws BaseException {
        senseCAPClient.getGroupManager().renameGroup("C1B08E961947A308", "SDk-4-G");
    }

    public static void removeGroup() throws BaseException {
        senseCAPClient.getGroupManager().removeGroup("5730E74FD3A817C0");
    }

    public static void getGroupList() throws BaseException {
        GroupResult groupResult = senseCAPClient.getGroupManager().createGroupQuery().build().execute();
        List<GroupInfo> groupInfos = groupResult.toList();
        groupInfos.forEach(groupInfo -> {
            System.out.println(groupInfo.toString());
            /*try {
                groupResult.renameGroup(groupInfo.getGroupUUID(), "新组名");
                groupResult.removeGroup(groupInfo.getGroupUUID());
            } catch (BaseException e) {
                e.printStackTrace();
            }*/
        });
    }

}

