# Boggle
- Cube configuration is taken from [here](https://stanford.edu/class/archive/cs/cs106x/cs106x.1132/handouts/17-Assignment-3-Boggle.pdf/)
- Resources on Tries: <br>[Tries and Boggle](https://www.geeksforgeeks.org/boggle-set-2-using-trie/?ref=lbp)<br> [Overview Video](https://www.youtube.com/watch?v=K5gYn7qL3lE)<br>[Implementation Video](https://www.youtube.com/watch?v=giiaIofn31A)

<br> <b> Game Rules: </b> adapted from [here](https://groupgames101.com/boggle-rules/) <br><br>
Objective: Create as many unique words as possible from a board of shuffled letter cubes within 3 minutes
1. Minimum word length is 4 letters
2. Words must be unique - no duplicates
3. Letters can only be used once in each word. Words are made by clicking letters adjacent to most recent clicked cube 
horizontally, vertically or diagonally. 
4. Scoring: 4 letters = 1, 5 letters  = 2, 6 letters = 3, 7 letters = 5, 8+ letters = 11
5. When game ends, click "Solve Boggle" to see how many possible words were in your board!


<br>Areas to improve:
1. Ability to un-click letters
2. Countdown timer is displayed
3. Ability to start a new game without re-running program
Current UI (not yet complete)
  ![Boggle Screenshot](BoggleScreenshot.png)