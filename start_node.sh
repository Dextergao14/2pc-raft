#!/bin/bash
# start_node.sh
VOTE_PORT=$1
DECISION_PORT=$2

# 1. boot python vote phase process
python phase_1_server_participants.py "$VOTE_PORT" &

java -jar twopc-decision-phase-server.jar "$DECISION_PORT" &

# maintain container block to avoid container exit
wait