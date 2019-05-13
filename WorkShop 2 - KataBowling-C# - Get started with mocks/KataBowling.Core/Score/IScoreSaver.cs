using System;

namespace KataBowling.Core.Score
{
    public interface IScoreSaver
    {
        bool PersistResults(string playerName, int score, DateTime dateTime);
    }
}
