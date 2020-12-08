package me.study.studyhalle.week4.assignment1;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.kohsuke.github.GHIssueState.ALL;

public class DashBoard {

    private static final String PROPERTY_FILE = "src/main/resources/token.properties";
    private static final String GIT_REPO = "rshak8912/studyhalle";

    public static void main(String[] args) throws IOException {
        // 깃헙과 관련된 객체를 생성.
        GitHub gitHub = GitHubBuilder.fromPropertyFile(PROPERTY_FILE).build();
        GHRepository ghRepository = gitHub.getRepository(GIT_REPO);

        List<GHIssue> ghIssues = ghRepository.getIssues(ALL);

        Map<String, Integer> participants = new HashMap<>();

        int issueCounts = ghIssues.size();

        for (GHIssue ghIssue : ghIssues) {

            List<GHIssueComment> comments = ghIssue.getComments();
            for (GHIssueComment comment : comments) {
                String username = comment.getUser().getName();
                if (participants.containsKey(username)) {
                    participants.put(username, participants.get(username) + 1); // 참가 횟수 + 1
                } else {
                    participants.put(username, 1);
                }
            }
        }
        participants.forEach((name, count) -> {
            System.out.printf("선원: " + name + " " + "참여율: %.2f%%\n", (double) (count / issueCounts) * 100);
        });

    }
}
