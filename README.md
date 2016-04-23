# Local-Stats
Create your own local stat database for minecraft.

# API-Usage

1. Import the PlayerProfile with '''java import com.th3shadowbroker.loc.obj.PlayerProfile'''

2. Create a new object '''java PlayerProfile profile = new PlayerProfile(Plugin <YOUR PLUGIN>, Player <TARGET PLAYER>)'''

3.1 Add a new custom stat-value with '''java profile.setStat(String <PATH>, String/Int/Boolean/Float <VALUE>)'''

3.2 Get a custom stat-value with ''' java profile.getStatStr(String <PATH>)''', '''java profile.getStatInt(String <PATH>)''', 
                               '''java profile.getStatFloat(String <PATH>)''', '''javaprofile.getStatBool(String <PATH>)'''
