# Local-Stats
Create your own local stat database for minecraft.

# API-Usage

1. Import the PlayerProfile with ```import com.th3shadowbroker.loc.obj.PlayerProfile```

2. Create a new object PlayerProfile ```profile = new PlayerProfile(Plugin <YOUR PLUGIN>, Player <TARGET PLAYER>)```

3.1 Add a new custom stat-value with ```profile.setStat(String <PATH>, String/Int/Boolean/Float <VALUE>)```

3.2 Get a custom stat-value with ```profile.getStatStr(String <PATH>),```
                                 ```profile.getStatInt(String <PATH>),```
                                 ```profile.getStatFloat(String <PATH>),```
                                 ```profile.getStatBool(String <PATH>)```

# License
All rights reserved
