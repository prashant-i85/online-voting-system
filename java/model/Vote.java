package model;

public class Vote {
    private int voteId;
    private int voterId;
    private int candidateId;
    private int electionId;

    public Vote() {}

    public Vote(int voteId, int voterId, int candidateId, int electionId) {
        this.voteId = voteId;
        this.voterId = voterId;
        this.candidateId = candidateId;
        this.electionId = electionId;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }
}
