public class VotingSystem {
    Map<String, Integer> votesMap = new HashMap<>();
    Map<String, Integer> voteOrderMap = new LinkedHashMap<>();
    TreeMap<String, Integer> sortedVotesMap = new TreeMap<>();

    public void vote(String candidate) {
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
        sortedVotesMap.put(candidate, sortedVotesMap.getOrDefault(candidate, 0) + 1);
    }

    public void displaySortedVotes() {
        System.out.println("Sorted Votes (TreeMap): " + sortedVotesMap);
    }

    public void displayVoteOrder() {
        System.out.println("Vote Order (LinkedHashMap): " + voteOrderMap);
    }
}