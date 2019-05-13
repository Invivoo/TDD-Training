using NFluent;
using NUnit.Framework;

namespace KataBowling.Core.Tests
{
    public class GameTest
    {
        private Game.Game _game;

        [SetUp]
        public void SetUp()
        {
            _game = new Game.Game();
        }

        [Test]
        public void Should_return_a_score_of_0_when_rolling_20_times_0_pins()
        {
            RollMany(20,0);
            Check.That(_game.Score()).Equals(0);
        }

        [Test]
        public void Should_return_a_score_of_20_when_rolling_20_times_1_pins()
        {
            RollMany(20, 1);
            Check.That(_game.Score()).Equals(20);
        }

        [Test]
        public void Should_return_a_score_of_16_when_rolling_one_spare_3_and_17_times_0_pins()
        {
            RollSpare();
            _game.Roll(3);
            RollMany(17, 0);
            Check.That(_game.Score()).Equals(16);
        }

        [Test]
        public void Should_return_a_score_of_24_when_rolling_one_strike_3_4_and_16_times_0_pins()
        {
            RollStrike();
            _game.Roll(3);
            _game.Roll(4);
            RollMany(16, 0);
            Check.That(_game.Score()).Equals(24);
        }

        [Test]
        public void Should_return_a_score_of_300_when_rolling_only_strikes()
        {
            RollMany(12, 10);
            Check.That(_game.Score()).Equals(300);
        }

        private void RollStrike()
        {
            _game.Roll(10);
        }

        private void RollMany(int n, int pins)
        {
            for (int i = 0; i < n; i++)
            {
                _game.Roll(pins);
            }
        }

        private void RollSpare()
        {
            _game.Roll(5);
            _game.Roll(5);
        }
    }
}
