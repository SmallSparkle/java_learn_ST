package ru.stqa.pft.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.pft.mantis.models.Issue;
import ru.stqa.pft.mantis.models.Project;
import ru.stqa.pft.mantis.tests.TestBase;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {


  private ApplicationManager app;

  public SoapHelper(ApplicationManager app) {
    this.app = app;
  }

  public Set<Project> getProjects() throws RemoteException, MalformedURLException, ServiceException {
    MantisConnectPortType mc = getMantisConnect();
    ProjectData[] projects = mc.mc_projects_get_user_accessible(
            System.getProperty("soap.login"), System.getProperty("soap.password"));
    return Arrays.asList(projects).stream()
            .map((p) -> new Project().withId(p.getId().intValue()).withName(p.getName()))
            .collect(Collectors.toSet());
  }

  private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
    MantisConnectPortType mc = new MantisConnectLocator()
            .getMantisConnectPort(
                    new URL(System.getProperty("soap.connect")));
    return mc;
  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    IssueData issueData = new IssueData();
    issueData.setSummary(issue.getSummary());
    issueData.setDescription(issue.getDescription());
    issueData.setProject(new ObjectRef
            (BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
//    issueData.setCategory();
    BigInteger issueId = mc.mc_issue_add(System.getProperty("soap.login"), System.getProperty("soap.password"), issueData);
    IssueData createdIssueData = mc.mc_issue_get(System.getProperty("soap.login"), System.getProperty("soap.password"), issueId);
return new Issue().withId(createdIssueData.getId().intValue())
        .withSummary(createdIssueData.getSummary())
        .withDescription(createdIssueData.getDescription())
        .withProject(new Project().withId(createdIssueData.getProject().getId().intValue())
                .withName(createdIssueData.getProject().getName()));
  }

}
