package model;

public class Candidate {
    private int candidateId;
    private String name;
    private String party;
    private int electionId;
    private int votes; // To hold the vote count

    public Candidate() {}

    public Candidate(int candidateId, String name, String party, int electionId) {
        this.candidateId = candidateId;
        this.name = name;
        this.party = party;
        this.electionId = electionId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
