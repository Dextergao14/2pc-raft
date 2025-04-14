# 2pc & Raft
2 Phase Commit  and Raft in Distributed System, demo readme.

# 2PC-Raft Demo

This repository contains two separate distributed systems demos:

- **Two-Phase Commit (2PC)**
- **Raft Leader Election and Log Replication**

## 📦 Setup

1. **Download & Unzip**

   - Download the ZIP archive of this project.
   - Unzip it and open the folder named `2pc-raft`.

---

## ▶️ Run 2PC

1. Navigate to the **2PC project** directory:

   ```bash
   cd twopc-decision-phase
   ```

2. Compile the Java coordinator and participant logic:

   ```bash
   mvn clean package
   ```

3. Return to the root folder:

   ```bash
   cd ..
   ```

4. Build Docker images (no cache):

   ```bash
   docker compose build --no-cache
   ```

5. Launch the 2PC system:

   ```bash
   docker compose up
   ```

6. Observe printed output for the **2PC decision protocol** execution.

---

## ⚙️ Run Raft

1. Navigate to the **Raft project** directory:

   ```bash
   cd raft/raft-leader-election
   ```

2. Compile the Java Raft coordinator:

   ```bash
   mvn clean package
   ```

3. Return to the `raft` folder:

   ```bash
   cd ..
   ```

4. Build Docker images (no cache), make sure you're in the raft directory:

   ```bash
   docker compose build --no-cache
   ```

5. Launch the Raft system:

   ```bash
   docker compose up
   ```

6. Observe printed logs for **Raft leader election and log replication**.

---

## 📝 Notes

- Make sure Docker and Maven are installed and available in your environment.
- This project uses gRPC and Protocol Buffers for inter-process communication.
- Log output will help you trace leader elections and log syncing in Raft, and commit decisions in 2PC.

---

Enjoy exploring distributed consensus protocols!


