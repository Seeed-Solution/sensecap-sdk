package cc.seeed.sensecap.manager;

import cc.seeed.sensecap.actions.Group;
import cc.seeed.sensecap.config.OpenApiConfig;
import cc.seeed.sensecap.exception.BaseException;
import cc.seeed.sensecap.interfaces.SenseCAPGroup;
import cc.seeed.sensecap.model.group.GroupInfo;
import cc.seeed.sensecap.queries.group.GroupQuery;
import cc.seeed.sensecap.queries.group.GroupQueryBuilder;

import java.util.List;

/**
 * @Author AG
 * @Description
 * @Date 2020/8/25 10:47
 * @Version V1.0
 */
public final class GroupManager implements SenseCAPGroup {

    private final OpenApiConfig openApiConfig;

    private final Group group;

    public GroupManager(OpenApiConfig openApiConfig) {
        this.openApiConfig = openApiConfig;
        this.group = new Group(openApiConfig);
    }


    public GroupQueryBuilder createGroupQuery() {
        return GroupQuery.newBuilder(openApiConfig);
    }

    @Override
    public GroupInfo createGroup(String groupName) throws BaseException {
        return group.createGroup(groupName);
    }

    @Override
    public void renameGroup(String groupUUID, String groupName) throws BaseException {
        group.renameGroup(groupUUID, groupName);
    }

    @Override
    public List<GroupInfo> getGroupList() throws BaseException {
        return group.getGroupList();
    }

    @Override
    public void removeGroup(String groupUUID) throws BaseException {
        group.removeGroup(groupUUID);
    }
}
