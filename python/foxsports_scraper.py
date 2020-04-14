from bs4 import BeautifulSoup
import requests
import json

url = 'https://www.foxsports.com/college-basketball/team-stats?season=2019&category=ADVANCED&group=2&time=0&team=1'
response = requests.get(url, timeout = 5)
content = BeautifulSoup(response.content, "html.parser")
table = BeautifulSoup(str(content.select("tr")),"html.parser")
teams = []
stats = table.find("td")
temp = stats.find_next("td")
i = 0
avg_off = 0
avg_def = 0
avg_pace = 0
avg_ft = 0
avg_three = 0
avg_ts = 0
avg_efg = 0
avg_to = 0
avg_off_reb = 0
avg_ft_fg = 0
avg_efg_allow = 0
avg_to_allow = 0
avg_def_reb_allow = 0
avg_ft_fg_allow = 0
for div in table.find_all("div"):
    name = div.span.next_sibling.next_sibling.next_sibling.next_sibling.string
    stat1 = temp.find_next("td")
    stat2 = stat1.find_next("td")
    stat3 = stat2.find_next("td")
    stat4 = stat3.find_next("td")
    stat5 = stat4.find_next("td")
    stat6 = stat5.find_next("td")
    stat7 = stat6.find_next("td")
    stat8 = stat7.find_next("td")
    stat9 = stat8.find_next("td")
    stat10 = stat9.find_next("td")
    stat11 = stat10.find_next("td")
    stat12 = stat11.find_next("td")
    stat13 = stat12.find_next("td")
    stat14 = stat13.find_next("td")
    team = {
        "teamName": name,
        "rank": i,
        "off_rtg": float(stat1.string),
        "def_rtg": float(stat2.string),
        "pace": float(stat3.string),
        "ft_rate": float(stat4.string),
        "three_fg_trend": float(stat5.string),
        "ts_percent": float(stat6.string),
        "efg_percent": float(stat7.string),
        "to_percent": float(stat8.string),
        "off_reb_percent": float(stat9.string),
        "ft_over_fga": float(stat10.string),
        "efg_percent_allow": float(stat11.string),
        "to_percent_allow": float(stat12.string),
        "def_reb_percent_allow": float(stat13.string),
        "ft_over_fga_allow": float(stat14.string)
        }
    avg_off = avg_off + float(stat1.string)
    avg_def = avg_def + float(stat2.string)
    avg_pace = avg_pace + float(stat3.string)
    avg_ft = avg_ft + float(stat4.string)
    avg_three = avg_three + float(stat5.string)
    avg_ts = avg_ts + float(stat6.string)
    avg_efg = avg_efg + float(stat7.string)
    avg_to = avg_to + float(stat8.string)
    avg_off_reb = avg_off_reb + float(stat9.string)
    avg_ft_fg = avg_ft_fg + float(stat10.string)
    avg_efg_allow = avg_efg_allow + float(stat11.string)
    avg_to_allow = avg_to_allow + float(stat12.string)
    avg_def_reb_allow = avg_def_reb_allow + float(stat13.string)
    avg_ft_fg_allow = avg_ft_fg_allow + float(stat14.string)
    i = i + 1
    teams.append(team)
    if stat14 is not None:
        temp = stat14.find_next("td")
    if temp is not None:
        temp = temp.find_next("td")
print(teams)
avg_off = avg_off / i
avg_def = avg_def / i
avg_pace = avg_pace / i
avg_ft = avg_ft / i
avg_three = avg_three / i
avg_ts = avg_ts / i
avg_efg = avg_efg / i
avg_to = avg_to / i
avg_off_reb = avg_off_reb / i
avg_ft_fg = avg_ft_fg_allow / i
avg_efg_allow = avg_efg_allow / i
avg_to_allow = avg_to_allow / i
avg_def_reb_allow = avg_def_reb_allow / i
avg_ft_fg_allow = avg_ft_fg_allow / i 
for team in teams:
    team["off_rtg"] = team["off_rtg"] / avg_off
    team["def_rtg"] = team["def_rtg"] / avg_def
    team["pace"] = team["pace"] / avg_pace
    team["ft_rate"] = team["ft_rate"] / avg_ft
    team["three_fg_trend"] = team["three_fg_trend"] / avg_three
    team["ts_percent"] = team["ts_percent"] / avg_ts
    team["efg_percent"] = team["efg_percent"] / avg_efg
    team["to_percent"] = team["to_percent"] / avg_to
    team["off_reb_percent"] = team["off_reb_percent"] / avg_off_reb
    team["ft_over_fga"] = team["ft_over_fga"] / avg_ft_fg
    team["efg_percent_allow"] = team["efg_percent_allow"] / avg_efg_allow
    team["to_percent_allow"] = team["to_percent_allow"] / avg_to_allow
    team["def_reb_percent_allow"] = team["def_reb_percent_allow"] / avg_def_reb_allow
    team["ft_over_fga_allow"] = team["ft_over_fga_allow"] / avg_ft_fg_allow
with open('tourney_team.json', 'w') as outputfile: json.dump(teams, outputfile)
